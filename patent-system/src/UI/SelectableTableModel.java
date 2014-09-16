package UI;


import invention.InventorCollaboration;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import org.w3c.dom.views.AbstractView;

import util.Attachment;
import util.TableRowRepresentation;



public class SelectableTableModel <T extends TableRowRepresentation> extends AbstractTableModel {
	String[] columns;
	ArrayList<T> data;
	ArrayList<Boolean> selects;
	private String type;
	
	public SelectableTableModel(String type, String[] ccolumns, Collection<T> ddata) {
		this.type=type;
		columns=ccolumns;
		data=new ArrayList<T>(ddata);
		selects=new ArrayList<Boolean>();
		for(int i=0;i<data.size();++i)
			selects.add(new Boolean(false));
		
	}

	@Override
	public void setValueAt(Object v, int r, int c) {
		if(c==0){
			selects.set(r, (Boolean)v);
			fireTableCellUpdated(r, c);
		}else if(isCellEditable(r, c)){
			fireTableCellUpdated(r, c);
		}
	}
	
	
	public ArrayList<T> getSelectedRows(){
		ArrayList<T> srows=new ArrayList<T>();
		for(int i=0;i<selects.size();++i)
			if(selects.get(i)==true)
				srows.add(data.get(i));
		return srows;
	}
		
	@Override
	public boolean isCellEditable(int r, int c) {
		if(c==0)
			return true;
		else 
			return false;
	}
	
	@Override
	public Object getValueAt(int r, int c) {
		if(c==0){
			return selects.get(r);
		}else
			return data.get(r).showRowRepresentation(this.type)[c-1];
	}
	
	@Override
	public int getRowCount() {
		return data.size();
	}
	
	@Override
	public String getColumnName(int c) {
		if(c==0)
			return "انتخاب";
		return columns[c-1];
	}
	
	@Override
	public int getColumnCount() {
		return columns.length+1;
	}
	
	@Override
	public Class<?> getColumnClass(int c) {
		if(c==0)
			return Boolean.class;
		return String.class;
	}

	
	public void addRow(T row){
		data.add(row);
		selects.add(new Boolean(false));
		fireTableRowsInserted(data.size(), data.size()+1);
	}
	
	public void removeRow(int rowind){
		selects.remove(rowind);
		data.remove(rowind);
		fireTableRowsDeleted(rowind, rowind+1);
	}

	public void clearSelection() {
		ArrayList<T> srows=getSelectedRows();
		for(T t: srows){
			setValueAt(new Boolean(false), data.indexOf(t), 0);
		}
		
	}
	
	public void setData(Collection<T> ddata){
		data=new ArrayList<T>(ddata);
		selects=new ArrayList<Boolean>(data.size());
		for(int i=0;i<data.size();++i){
			selects.add(new Boolean(false));
		}
		fireTableDataChanged();
	}

	public void removeRow(InventorCollaboration ic) {
		removeRow(data.indexOf(ic));
		
	}

	public void removeData(Attachment af) {
		int rowind=data.indexOf(af);
		removeRow(rowind);
		
	}
	
	public ArrayList<Integer> getSelectedRowsIndexes(){
		ArrayList<Integer> srows=new ArrayList<Integer>();
		for(int i=0;i<selects.size();++i)
			if(selects.get(i)==true)
				srows.add(i);
		return srows;
	}
	
	
}
