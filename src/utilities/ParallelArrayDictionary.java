package utilities;

/**
 * @author taterosen & georgelamb
 * @date 09/02/2022
 */

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ParallelArrayDictionary<Key,Value> implements Map<Key,Value> {

	// Parallel array-based implementation
	protected ArraySet<Key> _keys;
	protected ArrayList<Value> _values;

	public ParallelArrayDictionary()
	{
		_keys = new ArraySet<Key>();
		_values = new ArrayList<Value>();
	}

	@Override
	public int size() {
		return _keys.size();
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public boolean containsKey(Object key) {
		return _keys.contains(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return _values.contains(value);
	}

	@Override
	public Value get(Object key) {
		if (key == null || !_keys.contains(key)) return null;
		return _values.get(_keys.indexOf(key));
	}

	@Override
	public Value put(Key key, Value value) {
		if (key == null ||  _keys.contains(key)) return null;
		_keys.add(key);
		_values.add(value);
		return value;
	}

	@Override
	public Value remove(Object key) {
		if (key == null || !_keys.contains(key)) return null;
		Value removedValue = _values.get(_keys.indexOf(key));
		_values.set(_keys.indexOf(key), null);
		return removedValue;
	}

	@Override
	public void putAll(Map<? extends Key, ? extends Value> m) {
		for(Key k: m.keySet()) {
			if(!_keys.contains(k)) {
				_keys.add(k);
				_values.add(m.get(k));
			}
		}	
	}

	@Override
	public void clear() {
		_keys.clear();
		_values.clear();
	}

	@Override
	public Set<Key> keySet() {
		ArraySet<Key> keySet = new ArraySet<Key>();
		keySet.addAll(_keys);
		return keySet;
	}

	@Override
	public Collection<Value> values() {
		Collection<Value> valueCol = new ArrayList<Value>(_values);
		return valueCol;
	}

	@Override
	public Set<Entry<Key, Value>> entrySet() {
		Set<Entry<Key,Value>> entries = new ArraySet<Entry<Key,Value>>();
		for (int i = 0; i <this.size();i++) {
			entries.add(new AbstractMap.SimpleEntry<Key, Value>(_keys.get(i),_values.get(i)));
		}
		return entries;
	}
	
	@Override
	public String toString() {
		return this.toString();
	}
}