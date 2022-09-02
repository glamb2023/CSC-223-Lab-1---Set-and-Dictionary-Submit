/* @author 
 * 
 * 
 */

package utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Spliterator;

public class ArraySet<E> implements List<E>, Set<E>
{
	protected ArrayList<E> _list;

	public ArraySet()
	{
		_list = new ArrayList<E>();
	}
	
	public ArraySet(Collection<E> col) {
		_list = (ArrayList<E>) col;
	}

	@Override
	public int size() {
		return _list.size();
	}

	@Override
	public boolean isEmpty() {
		return _list.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return _list.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return _list.iterator();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return _list.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return _list.toArray(a);
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		if(_list.contains(e)) return false;
		return _list.add(e);
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return _list.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return _list.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		boolean addedAny = false;
		for(E val: c) {
			addedAny = _list.add(val) || addedAny;
		}
		return addedAny;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		boolean addedAny = false;
		for(E val: c) {
			if(!_list.contains(val)) {
				_list.add(index, val);
				index++;
				addedAny = true;
			}
		}
		return addedAny;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return _list.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return _list.retainAll(c);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		_list.clear();
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return _list.get(index);
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return _list.set(index, element);
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		_list.add(index, element);
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return _list.remove(index);
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return _list.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return _list.lastIndexOf(o);
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return _list.listIterator();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return _list.listIterator(index);
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return _list.subList(fromIndex, toIndex);
	}

	@Override
	public String toString() {
		return _list.toString();	
	}

	@Override
	public Spliterator<E> spliterator() {
		// TODO Auto-generated method stub
		return List.super.spliterator();
	}


}
