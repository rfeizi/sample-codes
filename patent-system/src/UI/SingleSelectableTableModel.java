package UI;

import java.util.ArrayList;
import java.util.Collection;

import util.TableRowRepresentation;

public class SingleSelectableTableModel<T extends TableRowRepresentation> extends
		SelectableTableModel<T> {
	
	
	
	public SingleSelectableTableModel(String type, String[] ccolumns,
			Collection<T> ddata) {
		super(type, ccolumns, ddata);
	}

	@Override
	public void setValueAt(Object v, int r, int c) {
		ArrayList<Integer> srows=getSelectedRowsIndexes();
		int selectedRow=-1;
		if(!srows.isEmpty())
			selectedRow=srows.get(0);
		
		super.setValueAt(v, r, c);
		if(c==0){
			if(selectedRow!=-1){
				selects.set(selectedRow, new Boolean(false));
				fireTableCellUpdated(selectedRow, c);
			}
		}
	}

	public boolean isSelected() {
		return getSelectedRow()!=null;
	}

	public T getSelectedRow() {
		ArrayList<T> srows=getSelectedRows();
		if(srows.isEmpty())
			return null;
		else
			return srows.get(0);
	}

}
