package DatabaseAndTools;

import java.awt.Component;
import java.awt.image.BufferedImage;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
public class DataTableRenderer extends DefaultTableCellRenderer implements TableCellRenderer {
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		ImagePanel i = new ImagePanel();
		i.img = (BufferedImage) value;
		return i;
	}
}
