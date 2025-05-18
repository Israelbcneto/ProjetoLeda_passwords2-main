package estrutura_dados;

import java.util.ArrayList;
import java.util.List;

public class SequentialList<K, V> {
    private final List<Entry<K, V>> entries;

    public SequentialList() {
        this.entries = new ArrayList<>();
    }

    // Tornar Entry pública e estática para que seja acessível externamente
    public static class Entry<K, V> {
        public final K key; // Alterar visibilidade para público
        public final V value; // Alterar visibilidade para público

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        for (Entry<K, V> entry : entries) {
            if (entry.key.equals(key)) {
                // Atualiza o valor se a chave já existir
                entries.set(entries.indexOf(entry), new Entry<>(key, value));
                return;
            }
        }
        entries.add(new Entry<>(key, value));
    }

    public V get(K key) {
        for (Entry<K, V> entry : entries) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        for (Entry<K, V> entry : entries) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public void remove(K key) {
        entries.removeIf(entry -> entry.key.equals(key));
    }

    public int size() {
        return entries.size();
    }

    // Método para obter a entrada pelo índice
    public Entry<K, V> getEntry(int index) {
        return entries.get(index);
    }
}
