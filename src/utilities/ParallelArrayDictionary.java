/*
 * @author trosen & glamb
 */

package utilities;

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
		// TODO Auto-generated method stub
		return _keys.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size() == 0;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return _keys.contains(key);
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return _values.contains(value);
	}

	@Override
	public Value get(Object key) {
		
		if (key == null || !_keys.contains(key)) return null;
		return _values.get(_keys.indexOf(key));
	}

	@Override
	public Value put(Key key, Value value) {
		// TODO Auto-generated method stub
		if (key == null ||  _keys.contains(key)) return null;
		_keys.add(key);
		_values.add(value);
		return value;
	}

	@Override
	public Value remove(Object key) {
		// TODO Auto-generated method stub
		if (key == null || !_keys.contains(key)) return null;
		return _values.remove(_keys.indexOf(key));
	}

	@Override
	public void putAll(Map<? extends Key, ? extends Value> m) {
		// TODO Auto-generated method stub
		for(Key k: m.keySet()) {
			if(!_keys.contains(k)) {
				_keys.add(k);
				_values.add(m.get(k));
			}
		}	
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		_keys.clear();
		_values.clear();
	}

	@Override
	public Set<Key> keySet() {
		// TODO Auto-generated method stub
		ArraySet<Key> keySet = new ArraySet<Key>();
		keySet.addAll(_keys);
		return keySet;
	}

	@Override
	public Collection<Value> values() {
		// TODO Auto-generated method stub
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