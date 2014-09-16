package UI;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.AbstractListModel;

public class SelectableListModel<T> extends AbstractListModel {
	ArrayList<T> data;
	
	public SelectableListModel(Collection<T> ddata) {
		super();
		data=new ArrayList<T>(ddata);
	}

	public SelectableListModel() {
		data=new ArrayList<T>();
	}

	@Override
	public T getElementAt(int index) {
		return data.get(index);
	}

	@Override
	public int getSize() {
		return data.size();
	}
	
	public void setData(ArrayList<T> ddata){
		data=ddata;
		fireContentsChanged(this, 0, getSize());
	}

}
