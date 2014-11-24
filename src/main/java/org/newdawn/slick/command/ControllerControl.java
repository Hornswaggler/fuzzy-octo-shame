package org.newdawn.slick.command;

/**
 * A control describing input provided from a controller. This allows controls to be
 * mapped to game pad inputs.
 * 
 * @author joverton
 */
abstract class ControllerControl implements Control {
    /** Indicates a button was pressed. */
    static final int BUTTON_EVENT = 0;
    /** Indicates left was pressed. */
    static final int LEFT_EVENT = 1;
    /** Indicates right was pressed. */
    static final int RIGHT_EVENT = 2;
    /** Indicates up was pressed. */
    static final int UP_EVENT = 3;
    /** Indicates down was pressed. */
    static final int DOWN_EVENT = 4;
    
    /** The type of event we're looking for. */
    private final int event;
    /** The index of the button we're waiting for. */
    private final int button;
    /** The index of the controller we're waiting on. */
    private final int controllerNumber;
    
    /**
     * Create a new controller control.
     * 
     * @param controllerNumber The index of the controller to react to
     * @param event The event to react to
     * @param button The button index to react to on a BUTTON event
     */
    ControllerControl(int controllerNumber, int event, int button) {
        this.event = event;
        this.button = button;
        this.controllerNumber = controllerNumber;
    }
    
    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object o) {
        if(o == null)
            return false;
        if(!(o instanceof ControllerControl))
            return false;
        
        ControllerControl c = (ControllerControl)o;
        
        return c.controllerNumber == controllerNumber && c.event == event && c.button == button;
    }
    
    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return event + button + controllerNumber;
    }
}
