package de.leonhardt.sbm.gui.renderer;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.apache.commons.lang3.text.WordUtils;

import de.leonhardt.sbm.gui.GuiUtils;
import de.leonhardt.sbm.gui.resource.IconLoader;
import de.leonhardt.sbm.xml.model.Sms;

/**
 * A renderer for ListModels containing Sms messages.
 * @author Frederik Leonhardt
 *
 */
public class MessageListCellRenderer extends DefaultListCellRenderer {

	private static final long serialVersionUID = 3041400497913312821L;
	
	// to load UI icons
	private final IconLoader il;

	public MessageListCellRenderer() {
		super();
		this.il = new IconLoader();
	}
	
	/**
	   * From http://java.sun.com/javase/6/docs/api/javax/swing/ListCellRenderer.html:
	   * 
	   * Return a component that has been configured to display the specified value. 
	   * That component's paint method is then called to "render" the cell. 
	   * If it is necessary to compute the dimensions of a list because the list cells do not have a fixed size, 
	   * this method is called to generate a component on which getPreferredSize can be invoked. 
	   * 
	   * jlist - the jlist we're painting
	   * value - the value returned by list.getModel().getElementAt(index).
	   * cellIndex - the cell index
	   * isSelected - true if the specified cell is currently selected
	   * cellHasFocus - true if the cell has focus
	   */
	@Override
	public Component getListCellRendererComponent(JList jlist, Object value,
			int cellIndex, boolean isSelected, boolean cellHasFocus) {
		
		// since there is no generic support in Java 6 ListModels yet, check if we actually get a sms
		if (value instanceof Sms) {
			Sms sms = (Sms) value;
			
			Date smsDate = new Date(sms.getDate());
			Component cComp = getMessageListEntryComponent(sms.getType(), smsDate, sms.getSubject(), sms.getBody(), sms.getStatus());
	
		    // set colors
			cComp.setForeground (isSelected ? jlist.getSelectionForeground() : jlist.getForeground());
			cComp.setBackground (isSelected ? jlist.getSelectionBackground() : jlist.getBackground());
			

		    return cComp;
		} else {
			// return normal component
			return super.getListCellRendererComponent(jlist, value, cellIndex, isSelected, cellHasFocus);
		}
	}
	
	/**
	 *  For each message, we build a JPanel looking somehow similar to this:
	 *  ____________________________
	 * | Date             Subject   |
	 * |                            |
	 * | Message Body               |
	 * | Message Body (ctn.)        |
	 * |____________________________|
	 * 
	 * @param contactName
	 * @param countryCode
	 * @param contactAddress
	 */
	private Component getMessageListEntryComponent(int messageType, Date messageDate, String messageSubject, String messageBody, int messageStatus) {
		// the main panel
		JPanel mPanel = new JPanel(new GridLayout(0, 1));
		
		//cPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		mPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		
		// we need several sub-elements
		// 1. header containing icons, date and subject
		JPanel mHeaderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		ImageIcon mTypeIcon = il.getMessageTypeIcon(messageType);
		ImageIcon mStatusIcon = il.getMessageStatusIcon(messageStatus);
		
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
		JLabel mDateLabel = new JLabel(df.format(messageDate), mTypeIcon, LEFT);
		JLabel mStatusLabel = new JLabel(mStatusIcon);
		
		mHeaderPanel.add(mDateLabel);
		mHeaderPanel.add(mStatusLabel);
		
		// subject
		//JLabel mSubjectLabel = new JLabel(messageSubject, RIGHT);
		
		//Font oldFont = cNameLabel.getFont();
		//int oldFontSize = cNameLabel.getFont().getSize();
		//cNameLabel.setFont(oldFont.deriveFont(oldFontSize+4f));
		
		// 2. label for body
		// prepare the text
		String wrappedBody = WordUtils.wrap(messageBody, 80, null, true);
		JTextArea mBodyTextArea = GuiUtils.buildLabelStyleTextArea(wrappedBody);
		
		// assemble..
		mPanel.add(mHeaderPanel);
		mPanel.add(mBodyTextArea);
		
		return mPanel;
	}

}
