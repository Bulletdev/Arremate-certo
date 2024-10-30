package org.apache.commons.collections4;

import java.util.SortedMap;

public interface Trie<K, V> extends IterableSortedMap<K, V> {
  SortedMap<K, V> prefixMap(K paramK);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\Trie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */