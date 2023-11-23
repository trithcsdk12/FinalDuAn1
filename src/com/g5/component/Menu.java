/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.g5.component;

import com.g5.event.EventMenuSelected;
import com.g5.model.Model_Menu;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author anhba
 */
public class Menu extends javax.swing.JPanel {

    private MigLayout layout;
    private JPanel panelMenu;
    private JButton cmdMenu;
    private JButton cmdExit;
    private JButton cmdMini;
    private Header header;
    private Info bottom;
    private Date date;
    private Date1 date1;
    private Setting setting;
    private EventMenuSelected eventMenuSelected;

    public void setEventMenuSelected(EventMenuSelected eventMenuSelected) {
        this.eventMenuSelected = eventMenuSelected;
    }

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        setOpaque(false);
        init();
    }

    void init() {
        setLayout(new MigLayout("wrap, fillx, insets 0", "5[fill]0", "5[]0[]5"));// vi tri cua toan menu ( item + component )
        panelMenu = new JPanel();
        header = new Header();
        bottom = new Info();
        date = new Date();
        setting = new Setting();
        createButtonMenu();
        createButtonLogout();
        createButtonMini();
        panelMenu.setOpaque(false);
        layout = new MigLayout("fillx, wrap", "0[fill]5", "0[]0[]5"); // component | []: Khoang cac ngang | [][]: Khoang cach doc
        panelMenu.setLayout(layout);
        date1 = new Date1();
        add(cmdMenu, "pos 1al 0al 100% 50");
        add(cmdExit, "pos 1al 1al 100% 50, height 50!");
        add(cmdMini, "pos 1al 1al 100% 50, height 50!");
        add(header);
        add(panelMenu);

        add(bottom);
        add(setting);
        add(date);
        add(date1);

        date.startClock();

    }

    public void addMenu(Model_Menu menu) {
        MenuItem item = new MenuItem(menu.getIcon(), menu.getMenuName(), panelMenu.getComponentCount());
        item.addEvent(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                clearMenu(index);
                repaint();
            }
        });
        item.addEvent(eventMenuSelected);
        panelMenu.add(item);
        if (item.getIndex() == 0) {
            item.setSelected(true);
        }
    }

    public void createButtonMenu() {
        cmdMenu = new JButton();
        cmdMenu.setContentAreaFilled(false); //  không cho phép vẽ nền của button
        cmdMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdMenu.setIcon(new ImageIcon(Menu.class.getResource("/com/g5/image/Menu_1.png")));
        cmdMenu.setBorder(new EmptyBorder(0, 1, 0, 16));
    }

    public void setEnableButtonMenu(boolean bl) {
        cmdMenu.setEnabled(bl);
    }

    public void createButtonLogout() {
        cmdExit = new JButton();
        cmdExit.setContentAreaFilled(false);
        cmdExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdExit.setIcon(new ImageIcon(Menu.class.getResource("/com/g5/image/Cancel.png")));
        cmdExit.setBorder(new EmptyBorder(0, 1, 0, 16)); // vị trí của Button exit
    }

    public void createButtonMini() {
        cmdMini = new JButton();
        cmdMini.setContentAreaFilled(false);
        cmdMini.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdMini.setIcon(new ImageIcon(Menu.class.getResource("/com/g5/image/Menu_1.png")));
        cmdMini.setBorder(new EmptyBorder(0, 1, 0, 165));
    }

    public void addEventButtonMenu(ActionListener evt) {
        cmdMenu.addActionListener(evt);
    }

    public void addEventButtonLogout(ActionListener evt) {
        cmdExit.addActionListener(evt);
    }

    private int x;
    private int y;

    public void initMoving(JFrame frame) {
        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x = me.getX();
                y = me.getY();
            }

        });
        header.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                frame.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint gra = new GradientPaint(0, 0, Color.decode("#136a8a"), 0, getHeight(), Color.decode("#267871"));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
    }

    private void clearMenu(int index) {
        for (Component com : panelMenu.getComponents()) {
            try {
                MenuItem item = (MenuItem) com;
                if (item.getIndex() != index) {
                    item.setSelected(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public void setAlpha(float alpha) {
        header.setAlpha(alpha);
        bottom.setAlpha(alpha);
        date.setAlpha(alpha);
        setting.setAlpha(alpha);
        date1.setAlpha(alpha);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
