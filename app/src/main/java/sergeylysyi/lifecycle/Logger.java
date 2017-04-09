package sergeylysyi.lifecycle;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Logger {

    private Map<String, List<MessagePair>> messagesByTag = new HashMap<>();
    private Map<String, List<onChangeListener>> listeners = new HashMap<>();

    void i(String tag, String message) {
        int newID;
        List<MessagePair> messagePairs;
        if (messagesByTag.containsKey(tag)) {
            messagePairs = messagesByTag.get(tag);
            if (!messagePairs.isEmpty()) {
                int lastId = messagePairs.get(messagePairs.size() - 1).id;
                newID = lastId + 1;
            } else {
                newID = 0;
            }
        } else {
            messagePairs = new ArrayList<>();
            messagesByTag.put(tag, messagePairs);
            newID = 0;
        }
        MessagePair newMessagePair = new MessagePair(newID, message);
        messagePairs.add(newID, newMessagePair);
        fire(tag, newMessagePair);
        Log.i(tag, message);
    }

    List<MessagePair> getAll(String tag) {
        List<MessagePair> messagePairs = messagesByTag.get(tag);
        if (messagePairs == null) {
            messagePairs = new ArrayList<>();
            messagesByTag.put(tag, messagePairs);
        }
        return messagePairs;
    }

    void addListener(String tag, onChangeListener listener) {
        if (listeners.containsKey(tag)) {
            listeners.get(tag).add(listener);
        } else {
            listeners.put(tag, new ArrayList<onChangeListener>());
            addListener(tag, listener);
        }
    }

    private void fire(String tag, MessagePair messagePair) {
        if (listeners.containsKey(tag)) {
            for (onChangeListener listener : listeners.get(tag)) {
                listener.onChange(messagePair);
            }
        }
    }

    static class MessagePair {
        protected int id;
        protected String message;

        MessagePair(int id, String message) {
            this.id = id;
            this.message = message;
        }

        @Override
        public String toString() {
            return message;
        }
    }

    interface onChangeListener {
        void onChange(MessagePair changedMessagePair);
    }
}
