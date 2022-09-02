package utilities;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Spliterator;


/**
 * @author georgelamb &taterosen
 * Using wrapping-around implementation to re-define all of the methods for an ArrayList
 * to make it into an ArrayList based Set.
 * 
 * <p> Bugs:
 * 
 * @author taterosen & georgelamb
 * @date 09/02/2022
 */

public class ArraySet<E> implements List<E>, Set<E>
{
	protected ArrayList<E> _list;

	public ArraySet(){
		_list = new ArrayList<E>();
	}
	
	public ArraySet(Collection<E> col) {
		_list = new ArrayList<E>(col);
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
		return _list.iterator();
	}

	@Override
	public Object[] toArray() {
		return _list.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return _list.toArray(a);
	}

	@Override
	public boolean add(E e) {
		if(_list.contains(e)) return false;
		return _list.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return _list.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return _list.containsAll(c);
	}


	/**
	 * Adds all items from collection to end of list.
	 */
	@Override
	public boolean addAll(Collection<? extends E> c) {
		boolean addedAny = false;
		for(E val: c) {
			addedAny = this.add(val) || addedAny;
		}
		return addedAny;
	}

	/**
	 * Adds all items to given index position.
	 */
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
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
		return _list.removeAll(c);
	}

	/**
	 * Keeps only the items from the given collection 
	 * in the set.
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		return _list.retainAll(c);
	}

	@Override
	public void clear() {
		_list.clear();
	}

	@Override
	public E get(int index) {
		return _list.get(index);
	}

	@Override
	public E set(int index, E element) {
		return _list.set(index, element);
	}

	@Override
	public void add(int index, E element) {
		_list.add(index, element);
	}

	@Override
	public E remove(int index) {
		return _list.remove(index);
	}

	@Override
	public int indexOf(Object o) {
		return _list.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return _list.lastIndexOf(o);
	}

	@Override
	public ListIterator<E> listIterator() {
		return _list.listIterator();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return _list.listIterator(index);
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return _list.subList(fromIndex, toIndex);
	}

	@Override
	public String toString() {
		return _list.toString();	
	}

	@Override
	public Spliterator<E> spliterator() {
		return List.super.spliterator();
	}

}
