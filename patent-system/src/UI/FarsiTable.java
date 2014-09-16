package UI;

import java.awt.ComponentOrientation;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class FarsiTable extends JTable {
	
	public FarsiTable(){
		super();
		this.setRowSelectionAllowed(false);
		this.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	}
	
	@Override
	public TableCellRenderer getCellRenderer(
			int row, int column) {
		if(column==0)
			return super.getCellRenderer(row, column);
		DefaultTableCellRenderer dtcr=new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.RIGHT);
		return dtcr;
	}
	
	

}
