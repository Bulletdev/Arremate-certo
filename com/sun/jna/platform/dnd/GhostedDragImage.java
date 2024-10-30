/*     */ package com.sun.jna.platform.dnd;
/*     */ 
/*     */ import com.sun.jna.platform.WindowUtils;
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.GraphicsConfiguration;
/*     */ import java.awt.Point;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Window;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.geom.Area;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.SwingUtilities;
/*     */ import javax.swing.Timer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GhostedDragImage
/*     */ {
/*     */   private static final float DEFAULT_ALPHA = 0.5F;
/*     */   private Window dragImage;
/*     */   private Point origin;
/*     */   private static final int SLIDE_INTERVAL = 33;
/*     */   
/*     */   public GhostedDragImage(Component paramComponent, final Icon icon, Point paramPoint1, final Point cursorOffset) {
/*  68 */     Window window = (paramComponent instanceof Window) ? (Window)paramComponent : SwingUtilities.getWindowAncestor(paramComponent);
/*     */     
/*  70 */     GraphicsConfiguration graphicsConfiguration = window.getGraphicsConfiguration();
/*  71 */     this.dragImage = new Window(JOptionPane.getRootFrame(), graphicsConfiguration)
/*     */       {
/*     */         public void paint(Graphics param1Graphics) {
/*  74 */           icon.paintIcon(this, param1Graphics, 0, 0);
/*     */         } private static final long serialVersionUID = 1L;
/*     */         public Dimension getPreferredSize() {
/*  77 */           return new Dimension(icon.getIconWidth(), icon.getIconHeight());
/*     */         }
/*     */         public Dimension getMinimumSize() {
/*  80 */           return getPreferredSize();
/*     */         }
/*     */         public Dimension getMaximumSize() {
/*  83 */           return getPreferredSize();
/*     */         }
/*     */       };
/*  86 */     this.dragImage.setFocusableWindowState(false);
/*  87 */     this.dragImage.setName("###overrideRedirect###");
/*  88 */     Icon icon = new Icon() {
/*     */         public int getIconHeight() {
/*  90 */           return icon.getIconHeight();
/*     */         }
/*     */         public int getIconWidth() {
/*  93 */           return icon.getIconWidth();
/*     */         }
/*     */         public void paintIcon(Component param1Component, Graphics param1Graphics, int param1Int1, int param1Int2) {
/*  96 */           param1Graphics = param1Graphics.create();
/*  97 */           Area area = new Area(new Rectangle(param1Int1, param1Int2, getIconWidth(), getIconHeight()));
/*     */           
/*  99 */           area.subtract(new Area(new Rectangle(param1Int1 + cursorOffset.x - 1, param1Int2 + cursorOffset.y - 1, 3, 3)));
/* 100 */           param1Graphics.setClip(area);
/* 101 */           icon.paintIcon(param1Component, param1Graphics, param1Int1, param1Int2);
/* 102 */           param1Graphics.dispose();
/*     */         }
/*     */       };
/*     */     
/* 106 */     this.dragImage.pack();
/* 107 */     WindowUtils.setWindowMask(this.dragImage, icon);
/* 108 */     WindowUtils.setWindowAlpha(this.dragImage, 0.5F);
/* 109 */     move(paramPoint1);
/* 110 */     this.dragImage.setVisible(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAlpha(float paramFloat) {
/* 117 */     WindowUtils.setWindowAlpha(this.dragImage, paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 122 */     this.dragImage.dispose();
/* 123 */     this.dragImage = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void move(Point paramPoint) {
/* 130 */     if (this.origin == null) {
/* 131 */       this.origin = paramPoint;
/*     */     }
/* 133 */     this.dragImage.setLocation(paramPoint.x, paramPoint.y);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void returnToOrigin() {
/* 139 */     final Timer timer = new Timer(33, null);
/* 140 */     timer.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent param1ActionEvent) {
/* 142 */             Point point1 = GhostedDragImage.this.dragImage.getLocationOnScreen();
/* 143 */             Point point2 = new Point(GhostedDragImage.this.origin);
/* 144 */             int i = (point2.x - point1.x) / 2;
/* 145 */             int j = (point2.y - point1.y) / 2;
/* 146 */             if (i != 0 || j != 0) {
/* 147 */               point1.translate(i, j);
/* 148 */               GhostedDragImage.this.move(point1);
/*     */             } else {
/*     */               
/* 151 */               timer.stop();
/* 152 */               GhostedDragImage.this.dispose();
/*     */             } 
/*     */           }
/*     */         });
/* 156 */     timer.setInitialDelay(0);
/* 157 */     timer.start();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\dnd\GhostedDragImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */