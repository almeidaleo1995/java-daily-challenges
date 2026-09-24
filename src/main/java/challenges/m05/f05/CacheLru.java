package challenges.m05.f05;

import java.util.LinkedHashMap;
import java.util.Map;

public final class CacheLru<K, V> extends LinkedHashMap<K, V> {

  public CacheLru(int capacidade) {
    throw new UnsupportedOperationException("TODO: implementar");
  }

  @Override
  protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
    throw new UnsupportedOperationException("TODO: implementar");
  }
}
