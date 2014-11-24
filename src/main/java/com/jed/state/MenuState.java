package com.jed.state;

import com.jed.util.Vector3f;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jlinde, Peter Colapietro
 *
 */
public class MenuState extends AbstractGameState {

    /**
     * 
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuState.class);

    /**
     * 
     */
    private UnicodeFont font;

    /**
     * 
     */
    private String daString;
    
    /**
     * 
     */
    private Vector3f coordinates;

    /**
     * 
     * @return daString
     */
    public String getDaString() {
        return daString;
    }

    /**
     * 
     * @param daString daString
     */
    public void setDaString(String daString) {
        this.daString = daString;
    }

    /**
     * 
     * @return coordinates
     */
    public Vector3f getCoordinates() {
        return coordinates;
    }

    /**
     * 
     * @param coordinates coordinates
     */
    public void setCoordinates(Vector3f coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public void entered() {
        java.awt.Font awtFont = new java.awt.Font("Arial", java.awt.Font.PLAIN, 24);
        font = new UnicodeFont(awtFont);
        font.getEffects().add(new ColorEffect(java.awt.Color.RED));
        font.addAsciiGlyphs();
        try {
            font.loadGlyphs();
        } catch (SlickException e) {
            LOGGER.error("Failed to load Font!", e);
        }
    }

    @Override
    public void leaving() {
    }

    @Override
    public void update() {
    }

    @Override
    public void render() {
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        font.drawString(coordinates.x, coordinates.y, daString);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
    }

}
