package de.leonhardt.sbm.gui.common;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ImageIcon;
import javax.swing.SwingWorker;

import org.beanfabrics.model.AbstractPM;
import org.beanfabrics.model.IconPM;
import org.beanfabrics.model.IntegerPM;
import org.beanfabrics.model.PMManager;
import org.beanfabrics.model.TextPM;
import org.beanfabrics.support.Service;

import de.leonhardt.sbm.gui.common.resource.IconService;

/**
 * The Presentation Model of the Status Bar.
 * It is read-only to the user/view.
 * 
 * This model can be atached to objects as a PropertyChangeListener.
 * It will listen to changes regarding:
 * - "progress": to update progress bar (expect int from 0-100)
 * - "text": to update status text (expect any object)
 * - "state": to update status icon (expect SwingWorker.Statevalue)
 * 
 * @author Frederik Leonhardt
 *
 */
public class StatusBarPM extends AbstractPM implements PropertyChangeListener {

	public TextPM status = new TextPM();
	public IconPM icon = new IconPM();
	public IntegerPM progress = new IntegerPM();

	private ImageIcon loadingIcon = null;
	
	private IconService is;
	
	public StatusBarPM() {
		PMManager.setup(this);
		
		status.setEditable(false);
		icon.setEditable(false);
		progress.setEditable(false);
		
		init("Welcome to BackupManager..", null, 0);
	}
	
	public StatusBarPM(String text, ImageIcon icon) {
		init(text, icon, 0);
	}
	
	private void init(String text, ImageIcon icon, int progress) {
		this.status.setText(text);
		this.icon.setIcon(icon);
		this.progress.setInteger(progress);
	}
	
	@Service
	public void setService(IconService is) {
		this.is = is;
		
		setLoadingIcon(this.is.getLoadingAnimation());
	}
	
	public void setStatus(String text, ImageIcon icon, int progress) {
		init(text, icon, progress);
	}
	
	public void setLoadingIcon(ImageIcon icon) {
		this.loadingIcon = icon;
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// automatically capture progress information
		if ("progress".equals(evt.getPropertyName())) {
			this.progress.setInteger((Integer)evt.getNewValue());
		}
		
		// automatically capture state information
		if ("state".equals(evt.getPropertyName())) {
            if (SwingWorker.StateValue.STARTED == evt.getNewValue()) {
                this.icon.setIcon(loadingIcon);
            }
            if (SwingWorker.StateValue.DONE == evt.getNewValue()) {
                this.icon.setIcon(null);
            }
        }
		
		// automatically capture text information
		if ("text".equals(evt.getPropertyName())) {
            this.status.setText(evt.getNewValue().toString());
        }
	}
}
