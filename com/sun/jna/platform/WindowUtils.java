/*      */ package com.sun.jna.platform;
/*      */ 
/*      */ import com.sun.jna.Memory;
/*      */ import com.sun.jna.Native;
/*      */ import com.sun.jna.NativeLong;
/*      */ import com.sun.jna.Platform;
/*      */ import com.sun.jna.Pointer;
/*      */ import com.sun.jna.platform.unix.X11;
/*      */ import com.sun.jna.platform.win32.GDI32;
/*      */ import com.sun.jna.platform.win32.Kernel32;
/*      */ import com.sun.jna.platform.win32.PsapiUtil;
/*      */ import com.sun.jna.platform.win32.User32;
/*      */ import com.sun.jna.platform.win32.Win32Exception;
/*      */ import com.sun.jna.platform.win32.WinBase;
/*      */ import com.sun.jna.platform.win32.WinDef;
/*      */ import com.sun.jna.platform.win32.WinGDI;
/*      */ import com.sun.jna.platform.win32.WinNT;
/*      */ import com.sun.jna.platform.win32.WinUser;
/*      */ import com.sun.jna.ptr.ByteByReference;
/*      */ import com.sun.jna.ptr.IntByReference;
/*      */ import com.sun.jna.ptr.PointerByReference;
/*      */ import java.awt.AWTEvent;
/*      */ import java.awt.AlphaComposite;
/*      */ import java.awt.BorderLayout;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Container;
/*      */ import java.awt.Dialog;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.Frame;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.Graphics2D;
/*      */ import java.awt.GraphicsConfiguration;
/*      */ import java.awt.GraphicsDevice;
/*      */ import java.awt.GraphicsEnvironment;
/*      */ import java.awt.Point;
/*      */ import java.awt.Rectangle;
/*      */ import java.awt.Shape;
/*      */ import java.awt.Toolkit;
/*      */ import java.awt.Window;
/*      */ import java.awt.event.AWTEventListener;
/*      */ import java.awt.event.ComponentEvent;
/*      */ import java.awt.event.ComponentListener;
/*      */ import java.awt.event.ContainerEvent;
/*      */ import java.awt.event.HierarchyEvent;
/*      */ import java.awt.event.HierarchyListener;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.event.WindowAdapter;
/*      */ import java.awt.event.WindowEvent;
/*      */ import java.awt.geom.Area;
/*      */ import java.awt.geom.PathIterator;
/*      */ import java.awt.image.BufferedImage;
/*      */ import java.awt.image.Raster;
/*      */ import java.awt.image.WritableRaster;
/*      */ import java.lang.reflect.Method;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.logging.Level;
/*      */ import java.util.logging.Logger;
/*      */ import javax.swing.Icon;
/*      */ import javax.swing.JComponent;
/*      */ import javax.swing.JLayeredPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JRootPane;
/*      */ import javax.swing.RootPaneContainer;
/*      */ import javax.swing.SwingUtilities;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class WindowUtils
/*      */ {
/*  167 */   private static final Logger LOG = Logger.getLogger(WindowUtils.class.getName());
/*      */   
/*      */   private static final String TRANSPARENT_OLD_BG = "transparent-old-bg";
/*      */   
/*      */   private static final String TRANSPARENT_OLD_OPAQUE = "transparent-old-opaque";
/*      */   
/*      */   private static final String TRANSPARENT_ALPHA = "transparent-alpha";
/*  174 */   public static final Shape MASK_NONE = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class HeavyweightForcer
/*      */     extends Window
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final boolean packed;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public HeavyweightForcer(Window param1Window) {
/*  196 */       super(param1Window);
/*  197 */       pack();
/*  198 */       this.packed = true;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isVisible() {
/*  206 */       return this.packed;
/*      */     }
/*      */ 
/*      */     
/*      */     public Rectangle getBounds() {
/*  211 */       return getOwner().getBounds();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   protected static class RepaintTrigger
/*      */     extends JComponent
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */     
/*      */     protected class Listener
/*      */       extends WindowAdapter
/*      */       implements AWTEventListener, ComponentListener, HierarchyListener
/*      */     {
/*      */       public void windowOpened(WindowEvent param2WindowEvent) {
/*  227 */         WindowUtils.RepaintTrigger.this.repaint();
/*      */       }
/*      */ 
/*      */       
/*      */       public void componentHidden(ComponentEvent param2ComponentEvent) {}
/*      */ 
/*      */       
/*      */       public void componentMoved(ComponentEvent param2ComponentEvent) {}
/*      */ 
/*      */       
/*      */       public void componentResized(ComponentEvent param2ComponentEvent) {
/*  238 */         WindowUtils.RepaintTrigger.this.setSize(WindowUtils.RepaintTrigger.this.getParent().getSize());
/*  239 */         WindowUtils.RepaintTrigger.this.repaint();
/*      */       }
/*      */ 
/*      */       
/*      */       public void componentShown(ComponentEvent param2ComponentEvent) {
/*  244 */         WindowUtils.RepaintTrigger.this.repaint();
/*      */       }
/*      */ 
/*      */       
/*      */       public void hierarchyChanged(HierarchyEvent param2HierarchyEvent) {
/*  249 */         WindowUtils.RepaintTrigger.this.repaint();
/*      */       }
/*      */ 
/*      */       
/*      */       public void eventDispatched(AWTEvent param2AWTEvent) {
/*  254 */         if (param2AWTEvent instanceof MouseEvent) {
/*  255 */           Component component = ((MouseEvent)param2AWTEvent).getComponent();
/*  256 */           if (component != null && 
/*  257 */             SwingUtilities.isDescendingFrom(component, WindowUtils.RepaintTrigger.this.content)) {
/*  258 */             MouseEvent mouseEvent = SwingUtilities.convertMouseEvent(component, (MouseEvent)param2AWTEvent, WindowUtils.RepaintTrigger.this.content);
/*  259 */             Component component1 = SwingUtilities.getDeepestComponentAt(WindowUtils.RepaintTrigger.this.content, mouseEvent.getX(), mouseEvent.getY());
/*  260 */             if (component1 != null) {
/*  261 */               WindowUtils.RepaintTrigger.this.setCursor(component1.getCursor());
/*      */             }
/*      */           } 
/*      */         } 
/*      */       }
/*      */     }
/*      */     
/*  268 */     private final Listener listener = createListener(); private final JComponent content;
/*      */     private Rectangle dirty;
/*      */     
/*      */     public RepaintTrigger(JComponent param1JComponent) {
/*  272 */       this.content = param1JComponent;
/*      */     }
/*      */ 
/*      */     
/*      */     public void addNotify() {
/*  277 */       super.addNotify();
/*  278 */       Window window = SwingUtilities.getWindowAncestor(this);
/*  279 */       setSize(getParent().getSize());
/*  280 */       window.addComponentListener(this.listener);
/*  281 */       window.addWindowListener(this.listener);
/*  282 */       Toolkit.getDefaultToolkit().addAWTEventListener(this.listener, 48L);
/*      */     }
/*      */ 
/*      */     
/*      */     public void removeNotify() {
/*  287 */       Toolkit.getDefaultToolkit().removeAWTEventListener(this.listener);
/*  288 */       Window window = SwingUtilities.getWindowAncestor(this);
/*  289 */       window.removeComponentListener(this.listener);
/*  290 */       window.removeWindowListener(this.listener);
/*  291 */       super.removeNotify();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected void paintComponent(Graphics param1Graphics) {
/*  297 */       Rectangle rectangle = param1Graphics.getClipBounds();
/*  298 */       if (this.dirty == null || !this.dirty.contains(rectangle)) {
/*  299 */         if (this.dirty == null) {
/*  300 */           this.dirty = rectangle;
/*      */         } else {
/*      */           
/*  303 */           this.dirty = this.dirty.union(rectangle);
/*      */         } 
/*  305 */         this.content.repaint(this.dirty);
/*      */       } else {
/*      */         
/*  308 */         this.dirty = null;
/*      */       } 
/*      */     }
/*      */     
/*      */     protected Listener createListener() {
/*  313 */       return new Listener();
/*      */     }
/*      */   }
/*      */   
/*      */   public static abstract class NativeWindowUtils {
/*      */     protected abstract class TransparentContentPane
/*      */       extends JPanel implements AWTEventListener {
/*      */       private static final long serialVersionUID = 1L;
/*      */       private boolean transparent;
/*      */       
/*      */       public TransparentContentPane(Container param2Container) {
/*  324 */         super(new BorderLayout());
/*  325 */         add(param2Container, "Center");
/*  326 */         setTransparent(true);
/*  327 */         if (param2Container instanceof JPanel) {
/*  328 */           ((JComponent)param2Container).setOpaque(false);
/*      */         }
/*      */       }
/*      */       
/*      */       public void addNotify() {
/*  333 */         super.addNotify();
/*  334 */         Toolkit.getDefaultToolkit().addAWTEventListener(this, 2L);
/*      */       }
/*      */       
/*      */       public void removeNotify() {
/*  338 */         Toolkit.getDefaultToolkit().removeAWTEventListener(this);
/*  339 */         super.removeNotify();
/*      */       }
/*      */       public void setTransparent(boolean param2Boolean) {
/*  342 */         this.transparent = param2Boolean;
/*  343 */         setOpaque(!param2Boolean);
/*  344 */         setDoubleBuffered(!param2Boolean);
/*  345 */         repaint();
/*      */       }
/*      */       
/*      */       public void eventDispatched(AWTEvent param2AWTEvent) {
/*  349 */         if (param2AWTEvent.getID() == 300 && 
/*  350 */           SwingUtilities.isDescendingFrom(((ContainerEvent)param2AWTEvent).getChild(), this)) {
/*  351 */           Component component = ((ContainerEvent)param2AWTEvent).getChild();
/*  352 */           WindowUtils.NativeWindowUtils.this.setDoubleBuffered(component, false);
/*      */         } 
/*      */       }
/*      */       
/*      */       public void paint(Graphics param2Graphics) {
/*  357 */         if (this.transparent) {
/*  358 */           Rectangle rectangle = param2Graphics.getClipBounds();
/*  359 */           int i = rectangle.width;
/*  360 */           int j = rectangle.height;
/*  361 */           if (getWidth() > 0 && getHeight() > 0) {
/*  362 */             BufferedImage bufferedImage = new BufferedImage(i, j, 3);
/*      */ 
/*      */             
/*  365 */             Graphics2D graphics2D = bufferedImage.createGraphics();
/*  366 */             graphics2D.setComposite(AlphaComposite.Clear);
/*  367 */             graphics2D.fillRect(0, 0, i, j);
/*  368 */             graphics2D.dispose();
/*      */             
/*  370 */             graphics2D = bufferedImage.createGraphics();
/*  371 */             graphics2D.translate(-rectangle.x, -rectangle.y);
/*  372 */             super.paint(graphics2D);
/*  373 */             graphics2D.dispose();
/*      */             
/*  375 */             paintDirect(bufferedImage, rectangle);
/*      */           } 
/*      */         } else {
/*      */           
/*  379 */           super.paint(param2Graphics);
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*      */       protected abstract void paintDirect(BufferedImage param2BufferedImage, Rectangle param2Rectangle);
/*      */     }
/*      */ 
/*      */     
/*      */     protected Window getWindow(Component param1Component) {
/*  389 */       return (param1Component instanceof Window) ? (Window)param1Component : 
/*  390 */         SwingUtilities.getWindowAncestor(param1Component);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void whenDisplayable(Component param1Component, final Runnable action) {
/*  397 */       if (param1Component.isDisplayable() && (!WindowUtils.Holder.requiresVisible || param1Component.isVisible())) {
/*  398 */         action.run();
/*      */       }
/*  400 */       else if (WindowUtils.Holder.requiresVisible) {
/*  401 */         getWindow(param1Component).addWindowListener(new WindowAdapter()
/*      */             {
/*      */               public void windowOpened(WindowEvent param2WindowEvent) {
/*  404 */                 param2WindowEvent.getWindow().removeWindowListener(this);
/*  405 */                 action.run();
/*      */               }
/*      */               
/*      */               public void windowClosed(WindowEvent param2WindowEvent) {
/*  409 */                 param2WindowEvent.getWindow().removeWindowListener(this);
/*      */               }
/*      */             });
/*      */       
/*      */       }
/*      */       else {
/*      */         
/*  416 */         param1Component.addHierarchyListener(new HierarchyListener()
/*      */             {
/*      */               public void hierarchyChanged(HierarchyEvent param2HierarchyEvent) {
/*  419 */                 if ((param2HierarchyEvent.getChangeFlags() & 0x2L) != 0L && param2HierarchyEvent
/*  420 */                   .getComponent().isDisplayable()) {
/*  421 */                   param2HierarchyEvent.getComponent().removeHierarchyListener(this);
/*  422 */                   action.run();
/*      */                 } 
/*      */               }
/*      */             });
/*      */       } 
/*      */     }
/*      */     
/*      */     protected Raster toRaster(Shape param1Shape) {
/*  430 */       WritableRaster writableRaster = null;
/*  431 */       if (param1Shape != WindowUtils.MASK_NONE) {
/*  432 */         Rectangle rectangle = param1Shape.getBounds();
/*  433 */         if (rectangle.width > 0 && rectangle.height > 0) {
/*  434 */           BufferedImage bufferedImage = new BufferedImage(rectangle.x + rectangle.width, rectangle.y + rectangle.height, 12);
/*      */ 
/*      */ 
/*      */           
/*  438 */           Graphics2D graphics2D = bufferedImage.createGraphics();
/*  439 */           graphics2D.setColor(Color.black);
/*  440 */           graphics2D.fillRect(0, 0, rectangle.x + rectangle.width, rectangle.y + rectangle.height);
/*  441 */           graphics2D.setColor(Color.white);
/*  442 */           graphics2D.fill(param1Shape);
/*  443 */           writableRaster = bufferedImage.getRaster();
/*      */         } 
/*      */       } 
/*  446 */       return writableRaster;
/*      */     }
/*      */     
/*      */     protected Raster toRaster(Component param1Component, Icon param1Icon) {
/*  450 */       WritableRaster writableRaster = null;
/*  451 */       if (param1Icon != null) {
/*      */         
/*  453 */         Rectangle rectangle = new Rectangle(0, 0, param1Icon.getIconWidth(), param1Icon.getIconHeight());
/*  454 */         BufferedImage bufferedImage = new BufferedImage(rectangle.width, rectangle.height, 2);
/*      */ 
/*      */         
/*  457 */         Graphics2D graphics2D = bufferedImage.createGraphics();
/*  458 */         graphics2D.setComposite(AlphaComposite.Clear);
/*  459 */         graphics2D.fillRect(0, 0, rectangle.width, rectangle.height);
/*  460 */         graphics2D.setComposite(AlphaComposite.SrcOver);
/*  461 */         param1Icon.paintIcon(param1Component, graphics2D, 0, 0);
/*  462 */         writableRaster = bufferedImage.getAlphaRaster();
/*      */       } 
/*  464 */       return writableRaster;
/*      */     }
/*      */     
/*      */     protected Shape toShape(Raster param1Raster) {
/*  468 */       final Area area = new Area(new Rectangle(0, 0, 0, 0));
/*  469 */       RasterRangesUtils.outputOccupiedRanges(param1Raster, new RasterRangesUtils.RangesOutput()
/*      */           {
/*      */             public boolean outputRange(int param2Int1, int param2Int2, int param2Int3, int param2Int4) {
/*  472 */               area.add(new Area(new Rectangle(param2Int1, param2Int2, param2Int3, param2Int4)));
/*  473 */               return true;
/*      */             }
/*      */           });
/*  476 */       return area;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setWindowAlpha(Window param1Window, float param1Float) {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isWindowAlphaSupported() {
/*  489 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public GraphicsConfiguration getAlphaCompatibleGraphicsConfiguration() {
/*  495 */       GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
/*  496 */       GraphicsDevice graphicsDevice = graphicsEnvironment.getDefaultScreenDevice();
/*  497 */       return graphicsDevice.getDefaultConfiguration();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setWindowTransparent(Window param1Window, boolean param1Boolean) {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void setDoubleBuffered(Component param1Component, boolean param1Boolean) {
/*  510 */       if (param1Component instanceof JComponent) {
/*  511 */         ((JComponent)param1Component).setDoubleBuffered(param1Boolean);
/*      */       }
/*  513 */       if (param1Component instanceof JRootPane && param1Boolean) {
/*  514 */         ((JRootPane)param1Component).setDoubleBuffered(true);
/*      */       }
/*  516 */       else if (param1Component instanceof Container) {
/*  517 */         Component[] arrayOfComponent = ((Container)param1Component).getComponents();
/*  518 */         for (byte b = 0; b < arrayOfComponent.length; b++) {
/*  519 */           setDoubleBuffered(arrayOfComponent[b], param1Boolean);
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     protected void setLayersTransparent(Window param1Window, boolean param1Boolean) {
/*  526 */       Color color = param1Boolean ? new Color(0, 0, 0, 0) : null;
/*  527 */       if (param1Window instanceof RootPaneContainer) {
/*  528 */         RootPaneContainer rootPaneContainer = (RootPaneContainer)param1Window;
/*  529 */         JRootPane jRootPane = rootPaneContainer.getRootPane();
/*  530 */         JLayeredPane jLayeredPane = jRootPane.getLayeredPane();
/*  531 */         Container container = jRootPane.getContentPane();
/*  532 */         JComponent jComponent = (container instanceof JComponent) ? (JComponent)container : null;
/*      */         
/*  534 */         if (param1Boolean) {
/*  535 */           jLayeredPane.putClientProperty("transparent-old-opaque", Boolean.valueOf(jLayeredPane.isOpaque()));
/*  536 */           jLayeredPane.setOpaque(false);
/*  537 */           jRootPane.putClientProperty("transparent-old-opaque", Boolean.valueOf(jRootPane.isOpaque()));
/*  538 */           jRootPane.setOpaque(false);
/*  539 */           if (jComponent != null) {
/*  540 */             jComponent.putClientProperty("transparent-old-opaque", Boolean.valueOf(jComponent.isOpaque()));
/*  541 */             jComponent.setOpaque(false);
/*      */           } 
/*  543 */           jRootPane.putClientProperty("transparent-old-bg", jRootPane
/*  544 */               .getParent().getBackground());
/*      */         } else {
/*      */           
/*  547 */           jLayeredPane.setOpaque(Boolean.TRUE.equals(jLayeredPane.getClientProperty("transparent-old-opaque")));
/*  548 */           jLayeredPane.putClientProperty("transparent-old-opaque", (Object)null);
/*  549 */           jRootPane.setOpaque(Boolean.TRUE.equals(jRootPane.getClientProperty("transparent-old-opaque")));
/*  550 */           jRootPane.putClientProperty("transparent-old-opaque", (Object)null);
/*  551 */           if (jComponent != null) {
/*  552 */             jComponent.setOpaque(Boolean.TRUE.equals(jComponent.getClientProperty("transparent-old-opaque")));
/*  553 */             jComponent.putClientProperty("transparent-old-opaque", (Object)null);
/*      */           } 
/*  555 */           color = (Color)jRootPane.getClientProperty("transparent-old-bg");
/*  556 */           jRootPane.putClientProperty("transparent-old-bg", (Object)null);
/*      */         } 
/*      */       } 
/*  559 */       param1Window.setBackground(color);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void setMask(Component param1Component, Raster param1Raster) {
/*  566 */       throw new UnsupportedOperationException("Window masking is not available");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void setWindowMask(Component param1Component, Raster param1Raster) {
/*  575 */       if (param1Component.isLightweight())
/*  576 */         throw new IllegalArgumentException("Component must be heavyweight: " + param1Component); 
/*  577 */       setMask(param1Component, param1Raster);
/*      */     }
/*      */ 
/*      */     
/*      */     public void setWindowMask(Component param1Component, Shape param1Shape) {
/*  582 */       setWindowMask(param1Component, toRaster(param1Shape));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setWindowMask(Component param1Component, Icon param1Icon) {
/*  590 */       setWindowMask(param1Component, toRaster(param1Component, param1Icon));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void setForceHeavyweightPopups(Window param1Window, boolean param1Boolean) {
/*  599 */       if (!(param1Window instanceof WindowUtils.HeavyweightForcer)) {
/*  600 */         Window[] arrayOfWindow = param1Window.getOwnedWindows();
/*  601 */         for (byte b = 0; b < arrayOfWindow.length; b++) {
/*  602 */           if (arrayOfWindow[b] instanceof WindowUtils.HeavyweightForcer) {
/*  603 */             if (param1Boolean)
/*      */               return; 
/*  605 */             arrayOfWindow[b].dispose();
/*      */           } 
/*      */         } 
/*  608 */         Boolean bool = Boolean.valueOf(System.getProperty("jna.force_hw_popups", "true"));
/*  609 */         if (param1Boolean && bool.booleanValue()) {
/*  610 */           new WindowUtils.HeavyweightForcer(param1Window);
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected BufferedImage getWindowIcon(WinDef.HWND param1HWND) {
/*  629 */       throw new UnsupportedOperationException("This platform is not supported, yet.");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected Dimension getIconSize(WinDef.HICON param1HICON) {
/*  645 */       throw new UnsupportedOperationException("This platform is not supported, yet.");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected List<DesktopWindow> getAllWindows(boolean param1Boolean) {
/*  666 */       throw new UnsupportedOperationException("This platform is not supported, yet.");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected String getWindowTitle(WinDef.HWND param1HWND) {
/*  682 */       throw new UnsupportedOperationException("This platform is not supported, yet.");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected String getProcessFilePath(WinDef.HWND param1HWND) {
/*  699 */       throw new UnsupportedOperationException("This platform is not supported, yet.");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected Rectangle getWindowLocationAndSize(WinDef.HWND param1HWND) {
/*  714 */       throw new UnsupportedOperationException("This platform is not supported, yet.");
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static class Holder
/*      */   {
/*      */     public static boolean requiresVisible;
/*      */     
/*      */     public static final WindowUtils.NativeWindowUtils INSTANCE;
/*      */ 
/*      */     
/*      */     static {
/*  727 */       if (Platform.isWindows()) {
/*  728 */         INSTANCE = new WindowUtils.W32WindowUtils();
/*      */       }
/*  730 */       else if (Platform.isMac()) {
/*  731 */         INSTANCE = new WindowUtils.MacWindowUtils();
/*      */       }
/*  733 */       else if (Platform.isX11()) {
/*  734 */         INSTANCE = new WindowUtils.X11WindowUtils();
/*      */         
/*  736 */         requiresVisible = System.getProperty("java.version").matches("^1\\.4\\..*");
/*      */       } else {
/*      */         
/*  739 */         String str = System.getProperty("os.name");
/*  740 */         throw new UnsupportedOperationException("No support for " + str);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   private static NativeWindowUtils getInstance() {
/*  746 */     return Holder.INSTANCE;
/*      */   }
/*      */   private static class W32WindowUtils extends NativeWindowUtils { private W32WindowUtils() {}
/*      */     
/*      */     private WinDef.HWND getHWnd(Component param1Component) {
/*  751 */       WinDef.HWND hWND = new WinDef.HWND();
/*  752 */       hWND.setPointer(Native.getComponentPointer(param1Component));
/*  753 */       return hWND;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isWindowAlphaSupported() {
/*  762 */       return Boolean.getBoolean("sun.java2d.noddraw");
/*      */     }
/*      */ 
/*      */     
/*      */     private boolean usingUpdateLayeredWindow(Window param1Window) {
/*  767 */       if (param1Window instanceof RootPaneContainer) {
/*  768 */         JRootPane jRootPane = ((RootPaneContainer)param1Window).getRootPane();
/*  769 */         return (jRootPane.getClientProperty("transparent-old-bg") != null);
/*      */       } 
/*  771 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void storeAlpha(Window param1Window, byte param1Byte) {
/*  778 */       if (param1Window instanceof RootPaneContainer) {
/*  779 */         JRootPane jRootPane = ((RootPaneContainer)param1Window).getRootPane();
/*  780 */         Byte byte_ = (param1Byte == -1) ? null : Byte.valueOf(param1Byte);
/*  781 */         jRootPane.putClientProperty("transparent-alpha", byte_);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     private byte getAlpha(Window param1Window) {
/*  787 */       if (param1Window instanceof RootPaneContainer) {
/*  788 */         JRootPane jRootPane = ((RootPaneContainer)param1Window).getRootPane();
/*  789 */         Byte byte_ = (Byte)jRootPane.getClientProperty("transparent-alpha");
/*  790 */         if (byte_ != null) {
/*  791 */           return byte_.byteValue();
/*      */         }
/*      */       } 
/*  794 */       return -1;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setWindowAlpha(final Window w, final float alpha) {
/*  799 */       if (!isWindowAlphaSupported()) {
/*  800 */         throw new UnsupportedOperationException("Set sun.java2d.noddraw=true to enable transparent windows");
/*      */       }
/*  802 */       whenDisplayable(w, new Runnable()
/*      */           {
/*      */             public void run() {
/*  805 */               WinDef.HWND hWND = WindowUtils.W32WindowUtils.this.getHWnd(w);
/*  806 */               User32 user32 = User32.INSTANCE;
/*  807 */               int i = user32.GetWindowLong(hWND, -20);
/*  808 */               byte b = (byte)((int)(255.0F * alpha) & 0xFF);
/*  809 */               if (WindowUtils.W32WindowUtils.this.usingUpdateLayeredWindow(w)) {
/*      */ 
/*      */                 
/*  812 */                 WinUser.BLENDFUNCTION bLENDFUNCTION = new WinUser.BLENDFUNCTION();
/*  813 */                 bLENDFUNCTION.SourceConstantAlpha = b;
/*  814 */                 bLENDFUNCTION.AlphaFormat = 1;
/*  815 */                 user32.UpdateLayeredWindow(hWND, null, null, null, null, null, 0, bLENDFUNCTION, 2);
/*      */ 
/*      */               
/*      */               }
/*  819 */               else if (alpha == 1.0F) {
/*  820 */                 i &= 0xFFF7FFFF;
/*  821 */                 user32.SetWindowLong(hWND, -20, i);
/*      */               } else {
/*      */                 
/*  824 */                 i |= 0x80000;
/*  825 */                 user32.SetWindowLong(hWND, -20, i);
/*  826 */                 user32.SetLayeredWindowAttributes(hWND, 0, b, 2);
/*      */               } 
/*      */               
/*  829 */               WindowUtils.W32WindowUtils.this.setForceHeavyweightPopups(w, (alpha != 1.0F));
/*  830 */               WindowUtils.W32WindowUtils.this.storeAlpha(w, b);
/*      */             }
/*      */           });
/*      */     }
/*      */ 
/*      */     
/*      */     private class W32TransparentContentPane
/*      */       extends WindowUtils.NativeWindowUtils.TransparentContentPane
/*      */     {
/*      */       private static final long serialVersionUID = 1L;
/*      */       private WinDef.HDC memDC;
/*      */       private WinDef.HBITMAP hBitmap;
/*      */       private Pointer pbits;
/*      */       private Dimension bitmapSize;
/*      */       
/*      */       public W32TransparentContentPane(Container param2Container) {
/*  846 */         super(param2Container);
/*      */       }
/*      */       private void disposeBackingStore() {
/*  849 */         GDI32 gDI32 = GDI32.INSTANCE;
/*  850 */         if (this.hBitmap != null) {
/*  851 */           gDI32.DeleteObject((WinNT.HANDLE)this.hBitmap);
/*  852 */           this.hBitmap = null;
/*      */         } 
/*  854 */         if (this.memDC != null) {
/*  855 */           gDI32.DeleteDC(this.memDC);
/*  856 */           this.memDC = null;
/*      */         } 
/*      */       }
/*      */       
/*      */       public void removeNotify() {
/*  861 */         super.removeNotify();
/*  862 */         disposeBackingStore();
/*      */       }
/*      */       
/*      */       public void setTransparent(boolean param2Boolean) {
/*  866 */         super.setTransparent(param2Boolean);
/*  867 */         if (!param2Boolean) {
/*  868 */           disposeBackingStore();
/*      */         }
/*      */       }
/*      */ 
/*      */       
/*      */       protected void paintDirect(BufferedImage param2BufferedImage, Rectangle param2Rectangle) {
/*  874 */         Window window = SwingUtilities.getWindowAncestor(this);
/*  875 */         GDI32 gDI32 = GDI32.INSTANCE;
/*  876 */         User32 user32 = User32.INSTANCE;
/*  877 */         int i = param2Rectangle.x;
/*  878 */         int j = param2Rectangle.y;
/*  879 */         Point point = SwingUtilities.convertPoint(this, i, j, window);
/*  880 */         int k = param2Rectangle.width;
/*  881 */         int m = param2Rectangle.height;
/*  882 */         int n = window.getWidth();
/*  883 */         int i1 = window.getHeight();
/*  884 */         WinDef.HDC hDC = user32.GetDC(null);
/*  885 */         WinNT.HANDLE hANDLE = null;
/*      */         try {
/*  887 */           if (this.memDC == null) {
/*  888 */             this.memDC = gDI32.CreateCompatibleDC(hDC);
/*      */           }
/*  890 */           if (this.hBitmap == null || !window.getSize().equals(this.bitmapSize)) {
/*  891 */             if (this.hBitmap != null) {
/*  892 */               gDI32.DeleteObject((WinNT.HANDLE)this.hBitmap);
/*  893 */               this.hBitmap = null;
/*      */             } 
/*  895 */             WinGDI.BITMAPINFO bITMAPINFO = new WinGDI.BITMAPINFO();
/*  896 */             bITMAPINFO.bmiHeader.biWidth = n;
/*  897 */             bITMAPINFO.bmiHeader.biHeight = i1;
/*  898 */             bITMAPINFO.bmiHeader.biPlanes = 1;
/*  899 */             bITMAPINFO.bmiHeader.biBitCount = 32;
/*  900 */             bITMAPINFO.bmiHeader.biCompression = 0;
/*  901 */             bITMAPINFO.bmiHeader.biSizeImage = n * i1 * 4;
/*  902 */             PointerByReference pointerByReference = new PointerByReference();
/*  903 */             this.hBitmap = gDI32.CreateDIBSection(this.memDC, bITMAPINFO, 0, pointerByReference, null, 0);
/*      */ 
/*      */             
/*  906 */             this.pbits = pointerByReference.getValue();
/*  907 */             this.bitmapSize = new Dimension(n, i1);
/*      */           } 
/*  909 */           hANDLE = gDI32.SelectObject(this.memDC, (WinNT.HANDLE)this.hBitmap);
/*  910 */           Raster raster = param2BufferedImage.getData();
/*  911 */           int[] arrayOfInt1 = new int[4];
/*  912 */           int[] arrayOfInt2 = new int[k];
/*  913 */           for (byte b = 0; b < m; b++) {
/*  914 */             int i2; for (i2 = 0; i2 < k; i2++) {
/*  915 */               raster.getPixel(i2, b, arrayOfInt1);
/*  916 */               int i3 = (arrayOfInt1[3] & 0xFF) << 24;
/*  917 */               int i4 = arrayOfInt1[2] & 0xFF;
/*  918 */               int i5 = (arrayOfInt1[1] & 0xFF) << 8;
/*  919 */               int i6 = (arrayOfInt1[0] & 0xFF) << 16;
/*  920 */               arrayOfInt2[i2] = i3 | i4 | i5 | i6;
/*      */             } 
/*  922 */             i2 = i1 - point.y + b - 1;
/*  923 */             this.pbits.write(((i2 * n + point.x) * 4), arrayOfInt2, 0, arrayOfInt2.length);
/*      */           } 
/*  925 */           WinUser.SIZE sIZE = new WinUser.SIZE();
/*  926 */           sIZE.cx = window.getWidth();
/*  927 */           sIZE.cy = window.getHeight();
/*  928 */           WinDef.POINT pOINT1 = new WinDef.POINT();
/*  929 */           pOINT1.x = window.getX();
/*  930 */           pOINT1.y = window.getY();
/*  931 */           WinDef.POINT pOINT2 = new WinDef.POINT();
/*  932 */           WinUser.BLENDFUNCTION bLENDFUNCTION = new WinUser.BLENDFUNCTION();
/*  933 */           WinDef.HWND hWND = WindowUtils.W32WindowUtils.this.getHWnd(window);
/*      */           
/*  935 */           ByteByReference byteByReference = new ByteByReference();
/*  936 */           IntByReference intByReference = new IntByReference();
/*  937 */           byte b1 = WindowUtils.W32WindowUtils.this.getAlpha(window);
/*      */           
/*      */           try {
/*  940 */             if (user32.GetLayeredWindowAttributes(hWND, null, byteByReference, intByReference) && (intByReference
/*  941 */               .getValue() & 0x2) != 0) {
/*  942 */               b1 = byteByReference.getValue();
/*      */             }
/*      */           }
/*  945 */           catch (UnsatisfiedLinkError unsatisfiedLinkError) {}
/*      */           
/*  947 */           bLENDFUNCTION.SourceConstantAlpha = b1;
/*  948 */           bLENDFUNCTION.AlphaFormat = 1;
/*  949 */           user32.UpdateLayeredWindow(hWND, hDC, pOINT1, sIZE, this.memDC, pOINT2, 0, bLENDFUNCTION, 2);
/*      */         } finally {
/*      */           
/*  952 */           user32.ReleaseDC(null, hDC);
/*  953 */           if (this.memDC != null && hANDLE != null) {
/*  954 */             gDI32.SelectObject(this.memDC, hANDLE);
/*      */           }
/*      */         } 
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setWindowTransparent(final Window w, final boolean transparent) {
/*  966 */       if (!(w instanceof RootPaneContainer)) {
/*  967 */         throw new IllegalArgumentException("Window must be a RootPaneContainer");
/*      */       }
/*  969 */       if (!isWindowAlphaSupported()) {
/*  970 */         throw new UnsupportedOperationException("Set sun.java2d.noddraw=true to enable transparent windows");
/*      */       }
/*      */       
/*  973 */       boolean bool = (w.getBackground() != null && w.getBackground().getAlpha() == 0);
/*  974 */       if (transparent == bool)
/*      */         return; 
/*  976 */       whenDisplayable(w, new Runnable()
/*      */           {
/*      */             public void run() {
/*  979 */               User32 user32 = User32.INSTANCE;
/*  980 */               WinDef.HWND hWND = WindowUtils.W32WindowUtils.this.getHWnd(w);
/*  981 */               int i = user32.GetWindowLong(hWND, -20);
/*  982 */               JRootPane jRootPane = ((RootPaneContainer)w).getRootPane();
/*  983 */               JLayeredPane jLayeredPane = jRootPane.getLayeredPane();
/*  984 */               Container container = jRootPane.getContentPane();
/*  985 */               if (container instanceof WindowUtils.W32WindowUtils.W32TransparentContentPane) {
/*  986 */                 ((WindowUtils.W32WindowUtils.W32TransparentContentPane)container).setTransparent(transparent);
/*      */               }
/*  988 */               else if (transparent) {
/*  989 */                 WindowUtils.W32WindowUtils.W32TransparentContentPane w32TransparentContentPane = new WindowUtils.W32WindowUtils.W32TransparentContentPane(container);
/*      */                 
/*  991 */                 jRootPane.setContentPane(w32TransparentContentPane);
/*  992 */                 jLayeredPane.add(new WindowUtils.RepaintTrigger(w32TransparentContentPane), JLayeredPane.DRAG_LAYER);
/*      */               } 
/*      */               
/*  995 */               if (transparent && !WindowUtils.W32WindowUtils.this.usingUpdateLayeredWindow(w)) {
/*  996 */                 i |= 0x80000;
/*  997 */                 user32.SetWindowLong(hWND, -20, i);
/*      */               }
/*  999 */               else if (!transparent && WindowUtils.W32WindowUtils.this.usingUpdateLayeredWindow(w)) {
/* 1000 */                 i &= 0xFFF7FFFF;
/* 1001 */                 user32.SetWindowLong(hWND, -20, i);
/*      */               } 
/* 1003 */               WindowUtils.W32WindowUtils.this.setLayersTransparent(w, transparent);
/* 1004 */               WindowUtils.W32WindowUtils.this.setForceHeavyweightPopups(w, transparent);
/* 1005 */               WindowUtils.W32WindowUtils.this.setDoubleBuffered(w, !transparent);
/*      */             }
/*      */           });
/*      */     }
/*      */ 
/*      */     
/*      */     public void setWindowMask(Component param1Component, Shape param1Shape) {
/* 1012 */       if (param1Shape instanceof Area && ((Area)param1Shape).isPolygonal()) {
/* 1013 */         setMask(param1Component, (Area)param1Shape);
/*      */       } else {
/*      */         
/* 1016 */         super.setWindowMask(param1Component, param1Shape);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     private void setWindowRegion(final Component w, final WinDef.HRGN hrgn) {
/* 1022 */       whenDisplayable(w, new Runnable()
/*      */           {
/*      */             public void run() {
/* 1025 */               GDI32 gDI32 = GDI32.INSTANCE;
/* 1026 */               User32 user32 = User32.INSTANCE;
/* 1027 */               WinDef.HWND hWND = WindowUtils.W32WindowUtils.this.getHWnd(w);
/*      */               try {
/* 1029 */                 user32.SetWindowRgn(hWND, hrgn, true);
/* 1030 */                 WindowUtils.W32WindowUtils.this.setForceHeavyweightPopups(WindowUtils.W32WindowUtils.this.getWindow(w), (hrgn != null));
/*      */               } finally {
/*      */                 
/* 1033 */                 gDI32.DeleteObject((WinNT.HANDLE)hrgn);
/*      */               } 
/*      */             }
/*      */           });
/*      */     }
/*      */ 
/*      */     
/*      */     private void setMask(Component param1Component, Area param1Area) {
/* 1041 */       GDI32 gDI32 = GDI32.INSTANCE;
/* 1042 */       PathIterator pathIterator = param1Area.getPathIterator(null);
/* 1043 */       boolean bool = (pathIterator.getWindingRule() == 1) ? true : true;
/*      */       
/* 1045 */       float[] arrayOfFloat = new float[6];
/* 1046 */       ArrayList<WinDef.POINT> arrayList = new ArrayList();
/* 1047 */       byte b1 = 0;
/* 1048 */       ArrayList<Integer> arrayList1 = new ArrayList();
/* 1049 */       while (!pathIterator.isDone()) {
/* 1050 */         int i = pathIterator.currentSegment(arrayOfFloat);
/* 1051 */         if (i == 0) {
/* 1052 */           b1 = 1;
/* 1053 */           arrayList.add(new WinDef.POINT((int)arrayOfFloat[0], (int)arrayOfFloat[1]));
/*      */         }
/* 1055 */         else if (i == 1) {
/* 1056 */           b1++;
/* 1057 */           arrayList.add(new WinDef.POINT((int)arrayOfFloat[0], (int)arrayOfFloat[1]));
/*      */         }
/* 1059 */         else if (i == 4) {
/* 1060 */           arrayList1.add(Integer.valueOf(b1));
/*      */         } else {
/*      */           
/* 1063 */           throw new RuntimeException("Area is not polygonal: " + param1Area);
/*      */         } 
/* 1065 */         pathIterator.next();
/*      */       } 
/* 1067 */       WinDef.POINT[] arrayOfPOINT1 = (WinDef.POINT[])(new WinDef.POINT()).toArray(arrayList.size());
/* 1068 */       WinDef.POINT[] arrayOfPOINT2 = arrayList.<WinDef.POINT>toArray(new WinDef.POINT[arrayList.size()]);
/* 1069 */       for (byte b2 = 0; b2 < arrayOfPOINT1.length; b2++) {
/* 1070 */         (arrayOfPOINT1[b2]).x = (arrayOfPOINT2[b2]).x;
/* 1071 */         (arrayOfPOINT1[b2]).y = (arrayOfPOINT2[b2]).y;
/*      */       } 
/* 1073 */       int[] arrayOfInt = new int[arrayList1.size()];
/* 1074 */       for (byte b3 = 0; b3 < arrayOfInt.length; b3++) {
/* 1075 */         arrayOfInt[b3] = ((Integer)arrayList1.get(b3)).intValue();
/*      */       }
/* 1077 */       WinDef.HRGN hRGN = gDI32.CreatePolyPolygonRgn(arrayOfPOINT1, arrayOfInt, arrayOfInt.length, bool);
/* 1078 */       setWindowRegion(param1Component, hRGN);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void setMask(Component param1Component, Raster param1Raster) {
/* 1083 */       GDI32 gDI32 = GDI32.INSTANCE;
/*      */       
/* 1085 */       final WinDef.HRGN region = (param1Raster != null) ? gDI32.CreateRectRgn(0, 0, 0, 0) : null;
/* 1086 */       if (hRGN != null) {
/* 1087 */         final WinDef.HRGN tempRgn = gDI32.CreateRectRgn(0, 0, 0, 0);
/*      */         try {
/* 1089 */           RasterRangesUtils.outputOccupiedRanges(param1Raster, new RasterRangesUtils.RangesOutput()
/*      */               {
/*      */                 public boolean outputRange(int param2Int1, int param2Int2, int param2Int3, int param2Int4) {
/* 1092 */                   GDI32 gDI32 = GDI32.INSTANCE;
/* 1093 */                   gDI32.SetRectRgn(tempRgn, param2Int1, param2Int2, param2Int1 + param2Int3, param2Int2 + param2Int4);
/* 1094 */                   return (gDI32.CombineRgn(region, region, tempRgn, 2) != 0);
/*      */                 }
/*      */               });
/*      */         } finally {
/*      */           
/* 1099 */           gDI32.DeleteObject((WinNT.HANDLE)hRGN1);
/*      */         } 
/*      */       } 
/* 1102 */       setWindowRegion(param1Component, hRGN);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public BufferedImage getWindowIcon(WinDef.HWND param1HWND) {
/* 1108 */       WinDef.DWORDByReference dWORDByReference = new WinDef.DWORDByReference();
/*      */       
/* 1110 */       WinDef.LRESULT lRESULT = User32.INSTANCE.SendMessageTimeout(param1HWND, 127, new WinDef.WPARAM(1L), new WinDef.LPARAM(0L), 2, 500, dWORDByReference);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1115 */       if (lRESULT.intValue() == 0)
/*      */       {
/* 1117 */         lRESULT = User32.INSTANCE.SendMessageTimeout(param1HWND, 127, new WinDef.WPARAM(0L), new WinDef.LPARAM(0L), 2, 500, dWORDByReference);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1122 */       if (lRESULT.intValue() == 0)
/*      */       {
/* 1124 */         lRESULT = User32.INSTANCE.SendMessageTimeout(param1HWND, 127, new WinDef.WPARAM(2L), new WinDef.LPARAM(0L), 2, 500, dWORDByReference);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1129 */       if (lRESULT.intValue() == 0) {
/*      */ 
/*      */         
/* 1132 */         lRESULT = new WinDef.LRESULT(User32.INSTANCE.GetClassLongPtr(param1HWND, -14).intValue());
/* 1133 */         dWORDByReference.getValue().setValue(lRESULT.intValue());
/*      */       } 
/* 1135 */       if (lRESULT.intValue() == 0) {
/*      */ 
/*      */         
/* 1138 */         lRESULT = new WinDef.LRESULT(User32.INSTANCE.GetClassLongPtr(param1HWND, -34).intValue());
/* 1139 */         dWORDByReference.getValue().setValue(lRESULT.intValue());
/*      */       } 
/* 1141 */       if (lRESULT.intValue() == 0) {
/* 1142 */         return null;
/*      */       }
/*      */ 
/*      */       
/* 1146 */       WinDef.HICON hICON = new WinDef.HICON(new Pointer(dWORDByReference.getValue().longValue()));
/* 1147 */       Dimension dimension = getIconSize(hICON);
/* 1148 */       if (dimension.width == 0 || dimension.height == 0) {
/* 1149 */         return null;
/*      */       }
/* 1151 */       int i = dimension.width;
/* 1152 */       int j = dimension.height;
/* 1153 */       byte b = 24;
/*      */       
/* 1155 */       byte[] arrayOfByte1 = new byte[i * j * 24 / 8];
/* 1156 */       Memory memory1 = new Memory(arrayOfByte1.length);
/* 1157 */       byte[] arrayOfByte2 = new byte[i * j * 24 / 8];
/* 1158 */       Memory memory2 = new Memory(arrayOfByte2.length);
/* 1159 */       WinGDI.BITMAPINFO bITMAPINFO = new WinGDI.BITMAPINFO();
/* 1160 */       WinGDI.BITMAPINFOHEADER bITMAPINFOHEADER = new WinGDI.BITMAPINFOHEADER();
/*      */       
/* 1162 */       bITMAPINFO.bmiHeader = bITMAPINFOHEADER;
/* 1163 */       bITMAPINFOHEADER.biWidth = i;
/* 1164 */       bITMAPINFOHEADER.biHeight = j;
/* 1165 */       bITMAPINFOHEADER.biPlanes = 1;
/* 1166 */       bITMAPINFOHEADER.biBitCount = 24;
/* 1167 */       bITMAPINFOHEADER.biCompression = 0;
/* 1168 */       bITMAPINFOHEADER.write();
/* 1169 */       bITMAPINFO.write();
/*      */       
/* 1171 */       WinDef.HDC hDC = User32.INSTANCE.GetDC(null);
/* 1172 */       WinGDI.ICONINFO iCONINFO = new WinGDI.ICONINFO();
/* 1173 */       User32.INSTANCE.GetIconInfo(hICON, iCONINFO);
/* 1174 */       iCONINFO.read();
/* 1175 */       GDI32.INSTANCE.GetDIBits(hDC, iCONINFO.hbmColor, 0, j, (Pointer)memory1, bITMAPINFO, 0);
/*      */       
/* 1177 */       memory1.read(0L, arrayOfByte1, 0, arrayOfByte1.length);
/* 1178 */       GDI32.INSTANCE.GetDIBits(hDC, iCONINFO.hbmMask, 0, j, (Pointer)memory2, bITMAPINFO, 0);
/*      */       
/* 1180 */       memory2.read(0L, arrayOfByte2, 0, arrayOfByte2.length);
/* 1181 */       BufferedImage bufferedImage = new BufferedImage(i, j, 2);
/*      */ 
/*      */ 
/*      */       
/* 1185 */       int k = 0, m = j - 1; int n;
/* 1186 */       for (n = 0; n < arrayOfByte1.length; n += 3) {
/* 1187 */         int i3 = arrayOfByte1[n] & 0xFF;
/* 1188 */         int i2 = arrayOfByte1[n + 1] & 0xFF;
/* 1189 */         int i1 = arrayOfByte1[n + 2] & 0xFF;
/* 1190 */         int i4 = 255 - arrayOfByte2[n] & 0xFF;
/* 1191 */         int i5 = i4 << 24 | i1 << 16 | i2 << 8 | i3;
/* 1192 */         bufferedImage.setRGB(k, m, i5);
/* 1193 */         k = (k + 1) % i;
/* 1194 */         if (k == 0) {
/* 1195 */           m--;
/*      */         }
/*      */       } 
/* 1198 */       User32.INSTANCE.ReleaseDC(null, hDC);
/*      */       
/* 1200 */       return bufferedImage;
/*      */     }
/*      */ 
/*      */     
/*      */     public Dimension getIconSize(WinDef.HICON param1HICON) {
/* 1205 */       WinGDI.ICONINFO iCONINFO = new WinGDI.ICONINFO();
/*      */       try {
/* 1207 */         if (!User32.INSTANCE.GetIconInfo(param1HICON, iCONINFO))
/* 1208 */           return new Dimension(); 
/* 1209 */         iCONINFO.read();
/*      */         
/* 1211 */         WinGDI.BITMAP bITMAP = new WinGDI.BITMAP();
/* 1212 */         if (iCONINFO.hbmColor != null && iCONINFO.hbmColor
/* 1213 */           .getPointer() != Pointer.NULL) {
/* 1214 */           int i = GDI32.INSTANCE.GetObject((WinNT.HANDLE)iCONINFO.hbmColor, bITMAP
/* 1215 */               .size(), bITMAP.getPointer());
/* 1216 */           bITMAP.read();
/* 1217 */           if (i > 0)
/* 1218 */             return new Dimension(bITMAP.bmWidth.intValue(), bITMAP.bmHeight
/* 1219 */                 .intValue()); 
/* 1220 */         } else if (iCONINFO.hbmMask != null && iCONINFO.hbmMask
/* 1221 */           .getPointer() != Pointer.NULL) {
/* 1222 */           int i = GDI32.INSTANCE.GetObject((WinNT.HANDLE)iCONINFO.hbmMask, bITMAP
/* 1223 */               .size(), bITMAP.getPointer());
/* 1224 */           bITMAP.read();
/* 1225 */           if (i > 0)
/* 1226 */             return new Dimension(bITMAP.bmWidth.intValue(), bITMAP.bmHeight.intValue() / 2); 
/*      */         } 
/*      */       } finally {
/* 1229 */         if (iCONINFO.hbmColor != null && iCONINFO.hbmColor
/* 1230 */           .getPointer() != Pointer.NULL)
/* 1231 */           GDI32.INSTANCE.DeleteObject((WinNT.HANDLE)iCONINFO.hbmColor); 
/* 1232 */         if (iCONINFO.hbmMask != null && iCONINFO.hbmMask
/* 1233 */           .getPointer() != Pointer.NULL) {
/* 1234 */           GDI32.INSTANCE.DeleteObject((WinNT.HANDLE)iCONINFO.hbmMask);
/*      */         }
/*      */       } 
/* 1237 */       return new Dimension();
/*      */     }
/*      */ 
/*      */     
/*      */     public List<DesktopWindow> getAllWindows(final boolean onlyVisibleWindows) {
/* 1242 */       final LinkedList<DesktopWindow> result = new LinkedList();
/*      */       
/* 1244 */       WinUser.WNDENUMPROC wNDENUMPROC = new WinUser.WNDENUMPROC()
/*      */         {
/*      */           public boolean callback(WinDef.HWND param2HWND, Pointer param2Pointer)
/*      */           {
/*      */             try {
/* 1249 */               boolean bool = (!onlyVisibleWindows || User32.INSTANCE.IsWindowVisible(param2HWND)) ? true : false;
/* 1250 */               if (bool) {
/* 1251 */                 String str1 = WindowUtils.W32WindowUtils.this.getWindowTitle(param2HWND);
/* 1252 */                 String str2 = WindowUtils.W32WindowUtils.this.getProcessFilePath(param2HWND);
/* 1253 */                 Rectangle rectangle = WindowUtils.W32WindowUtils.this.getWindowLocationAndSize(param2HWND);
/* 1254 */                 result.add(new DesktopWindow(param2HWND, str1, str2, rectangle));
/*      */               }
/*      */             
/* 1257 */             } catch (Exception exception) {
/*      */               
/* 1259 */               exception.printStackTrace();
/*      */             } 
/*      */             
/* 1262 */             return true;
/*      */           }
/*      */         };
/*      */       
/* 1266 */       if (!User32.INSTANCE.EnumWindows(wNDENUMPROC, null)) {
/* 1267 */         throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */       }
/* 1269 */       return linkedList;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String getWindowTitle(WinDef.HWND param1HWND) {
/* 1275 */       int i = User32.INSTANCE.GetWindowTextLength(param1HWND) + 1;
/* 1276 */       char[] arrayOfChar = new char[i];
/* 1277 */       int j = User32.INSTANCE.GetWindowText(param1HWND, arrayOfChar, arrayOfChar.length);
/*      */ 
/*      */       
/* 1280 */       return Native.toString(Arrays.copyOfRange(arrayOfChar, 0, j));
/*      */     }
/*      */ 
/*      */     
/*      */     public String getProcessFilePath(WinDef.HWND param1HWND) {
/* 1285 */       IntByReference intByReference = new IntByReference();
/* 1286 */       User32.INSTANCE.GetWindowThreadProcessId(param1HWND, intByReference);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1295 */       WinNT.HANDLE hANDLE = Kernel32.INSTANCE.OpenProcess(1024, false, intByReference
/*      */ 
/*      */           
/* 1298 */           .getValue());
/*      */       
/* 1300 */       if (hANDLE == null) {
/* 1301 */         if (Kernel32.INSTANCE.GetLastError() != 5) {
/* 1302 */           throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */         }
/* 1304 */         hANDLE = Kernel32.INSTANCE.OpenProcess(4096, false, intByReference
/*      */ 
/*      */             
/* 1307 */             .getValue());
/*      */         
/* 1309 */         if (hANDLE == null) {
/* 1310 */           if (Kernel32.INSTANCE.GetLastError() != 5) {
/* 1311 */             throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */           }
/*      */           
/* 1314 */           return "";
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*      */       try {
/* 1321 */         String str = PsapiUtil.GetProcessImageFileName(hANDLE);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1329 */         if (str.startsWith("\\Device\\Mup\\")) {
/* 1330 */           return "\\" + str.substring(11);
/*      */         }
/*      */ 
/*      */ 
/*      */         
/* 1335 */         char[] arrayOfChar = new char[50];
/* 1336 */         WinNT.HANDLE hANDLE1 = Kernel32.INSTANCE.FindFirstVolume(arrayOfChar, 50);
/* 1337 */         if (hANDLE1 == null || hANDLE1.equals(WinBase.INVALID_HANDLE_VALUE)) {
/* 1338 */           throw new Win32Exception(Native.getLastError());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       }
/*      */       finally {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1361 */         Kernel32.INSTANCE.CloseHandle(hANDLE);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public Rectangle getWindowLocationAndSize(WinDef.HWND param1HWND) {
/* 1367 */       WinDef.RECT rECT = new WinDef.RECT();
/* 1368 */       if (!User32.INSTANCE.GetWindowRect(param1HWND, rECT)) {
/* 1369 */         throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */       }
/* 1371 */       return new Rectangle(rECT.left, rECT.top, Math.abs(rECT.right - rECT.left), 
/* 1372 */           Math.abs(rECT.bottom - rECT.top));
/*      */     } }
/*      */   
/*      */   private static class MacWindowUtils extends NativeWindowUtils {
/*      */     private static final String WDRAG = "apple.awt.draggableWindowBackground";
/*      */     
/*      */     public boolean isWindowAlphaSupported() {
/* 1379 */       return true;
/*      */     }
/*      */     private MacWindowUtils() {}
/*      */     private OSXMaskingContentPane installMaskingPane(Window param1Window) {
/*      */       OSXMaskingContentPane oSXMaskingContentPane;
/* 1384 */       if (param1Window instanceof RootPaneContainer) {
/*      */         
/* 1386 */         RootPaneContainer rootPaneContainer = (RootPaneContainer)param1Window;
/* 1387 */         Container container = rootPaneContainer.getContentPane();
/* 1388 */         if (container instanceof OSXMaskingContentPane) {
/* 1389 */           oSXMaskingContentPane = (OSXMaskingContentPane)container;
/*      */         } else {
/*      */           
/* 1392 */           oSXMaskingContentPane = new OSXMaskingContentPane(container);
/*      */           
/* 1394 */           rootPaneContainer.setContentPane(oSXMaskingContentPane);
/*      */         } 
/*      */       } else {
/*      */         
/* 1398 */         Component component = (param1Window.getComponentCount() > 0) ? param1Window.getComponent(0) : null;
/* 1399 */         if (component instanceof OSXMaskingContentPane) {
/* 1400 */           oSXMaskingContentPane = (OSXMaskingContentPane)component;
/*      */         } else {
/*      */           
/* 1403 */           oSXMaskingContentPane = new OSXMaskingContentPane(component);
/* 1404 */           param1Window.add(oSXMaskingContentPane);
/*      */         } 
/*      */       } 
/* 1407 */       return oSXMaskingContentPane;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setWindowTransparent(Window param1Window, boolean param1Boolean) {
/* 1421 */       boolean bool = (param1Window.getBackground() != null && param1Window.getBackground().getAlpha() == 0);
/* 1422 */       if (param1Boolean != bool) {
/* 1423 */         setBackgroundTransparent(param1Window, param1Boolean, "setWindowTransparent");
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private void fixWindowDragging(Window param1Window, String param1String) {
/* 1430 */       if (param1Window instanceof RootPaneContainer) {
/* 1431 */         JRootPane jRootPane = ((RootPaneContainer)param1Window).getRootPane();
/* 1432 */         Boolean bool = (Boolean)jRootPane.getClientProperty("apple.awt.draggableWindowBackground");
/* 1433 */         if (bool == null) {
/* 1434 */           jRootPane.putClientProperty("apple.awt.draggableWindowBackground", Boolean.FALSE);
/* 1435 */           if (param1Window.isDisplayable()) {
/* 1436 */             WindowUtils.LOG.log(Level.WARNING, "{0}(): To avoid content dragging, {1}() must be called before the window is realized, or apple.awt.draggableWindowBackground must be set to Boolean.FALSE before the window is realized.  If you really want content dragging, set apple.awt.draggableWindowBackground on the window''s root pane to Boolean.TRUE before calling {2}() to hide this message.", new Object[] { param1String, param1String, param1String });
/*      */           }
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setWindowAlpha(final Window w, final float alpha) {
/* 1453 */       if (w instanceof RootPaneContainer) {
/* 1454 */         JRootPane jRootPane = ((RootPaneContainer)w).getRootPane();
/* 1455 */         jRootPane.putClientProperty("Window.alpha", Float.valueOf(alpha));
/* 1456 */         fixWindowDragging(w, "setWindowAlpha");
/*      */       } 
/* 1458 */       whenDisplayable(w, new Runnable()
/*      */           {
/*      */             
/*      */             public void run()
/*      */             {
/*      */               try {
/* 1464 */                 Method method1 = w.getClass().getMethod("getPeer", new Class[0]);
/* 1465 */                 Object object = method1.invoke(w, new Object[0]);
/* 1466 */                 Method method2 = object.getClass().getMethod("setAlpha", new Class[] { float.class });
/* 1467 */                 method2.invoke(object, new Object[] { Float.valueOf(this.val$alpha) });
/*      */               }
/* 1469 */               catch (Exception exception) {}
/*      */             }
/*      */           });
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected void setWindowMask(Component param1Component, Raster param1Raster) {
/* 1477 */       if (param1Raster != null) {
/* 1478 */         setWindowMask(param1Component, toShape(param1Raster));
/*      */       } else {
/*      */         
/* 1481 */         setWindowMask(param1Component, new Rectangle(0, 0, param1Component.getWidth(), param1Component
/* 1482 */               .getHeight()));
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public void setWindowMask(Component param1Component, Shape param1Shape) {
/* 1488 */       if (param1Component instanceof Window) {
/* 1489 */         Window window = (Window)param1Component;
/* 1490 */         OSXMaskingContentPane oSXMaskingContentPane = installMaskingPane(window);
/* 1491 */         oSXMaskingContentPane.setMask(param1Shape);
/* 1492 */         setBackgroundTransparent(window, (param1Shape != WindowUtils.MASK_NONE), "setWindowMask");
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private static class OSXMaskingContentPane
/*      */       extends JPanel
/*      */     {
/*      */       private static final long serialVersionUID = 1L;
/*      */       
/*      */       private Shape shape;
/*      */ 
/*      */       
/*      */       public OSXMaskingContentPane(Component param2Component) {
/* 1507 */         super(new BorderLayout());
/* 1508 */         if (param2Component != null) {
/* 1509 */           add(param2Component, "Center");
/*      */         }
/*      */       }
/*      */       
/*      */       public void setMask(Shape param2Shape) {
/* 1514 */         this.shape = param2Shape;
/* 1515 */         repaint();
/*      */       }
/*      */ 
/*      */       
/*      */       public void paint(Graphics param2Graphics) {
/* 1520 */         Graphics2D graphics2D = (Graphics2D)param2Graphics.create();
/* 1521 */         graphics2D.setComposite(AlphaComposite.Clear);
/* 1522 */         graphics2D.fillRect(0, 0, getWidth(), getHeight());
/* 1523 */         graphics2D.dispose();
/* 1524 */         if (this.shape != null) {
/* 1525 */           graphics2D = (Graphics2D)param2Graphics.create();
/* 1526 */           graphics2D.setClip(this.shape);
/* 1527 */           super.paint(graphics2D);
/* 1528 */           graphics2D.dispose();
/*      */         } else {
/*      */           
/* 1531 */           super.paint(param2Graphics);
/*      */         } 
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     private void setBackgroundTransparent(Window param1Window, boolean param1Boolean, String param1String) {
/* 1538 */       JRootPane jRootPane = (param1Window instanceof RootPaneContainer) ? ((RootPaneContainer)param1Window).getRootPane() : null;
/* 1539 */       if (param1Boolean) {
/* 1540 */         if (jRootPane != null) {
/* 1541 */           jRootPane.putClientProperty("transparent-old-bg", param1Window.getBackground());
/*      */         }
/* 1543 */         param1Window.setBackground(new Color(0, 0, 0, 0));
/*      */       
/*      */       }
/* 1546 */       else if (jRootPane != null) {
/* 1547 */         Color color = (Color)jRootPane.getClientProperty("transparent-old-bg");
/*      */ 
/*      */ 
/*      */         
/* 1551 */         if (color != null) {
/* 1552 */           color = new Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
/*      */         }
/* 1554 */         param1Window.setBackground(color);
/* 1555 */         jRootPane.putClientProperty("transparent-old-bg", (Object)null);
/*      */       } else {
/*      */         
/* 1558 */         param1Window.setBackground((Color)null);
/*      */       } 
/*      */       
/* 1561 */       fixWindowDragging(param1Window, param1String);
/*      */     } }
/*      */   
/*      */   private static class X11WindowUtils extends NativeWindowUtils {
/*      */     private boolean didCheck;
/*      */     
/*      */     private static X11.Pixmap createBitmap(X11.Display param1Display, X11.Window param1Window, Raster param1Raster) {
/* 1568 */       X11 x11 = X11.INSTANCE;
/* 1569 */       Rectangle rectangle = param1Raster.getBounds();
/* 1570 */       int i = rectangle.x + rectangle.width;
/* 1571 */       int j = rectangle.y + rectangle.height;
/* 1572 */       X11.Pixmap pixmap = x11.XCreatePixmap(param1Display, (X11.Drawable)param1Window, i, j, 1);
/* 1573 */       X11.GC gC = x11.XCreateGC(param1Display, (X11.Drawable)pixmap, new NativeLong(0L), null);
/* 1574 */       if (gC == null) {
/* 1575 */         return null;
/*      */       }
/* 1577 */       x11.XSetForeground(param1Display, gC, new NativeLong(0L));
/* 1578 */       x11.XFillRectangle(param1Display, (X11.Drawable)pixmap, gC, 0, 0, i, j);
/* 1579 */       final ArrayList<Rectangle> rlist = new ArrayList();
/*      */       try {
/* 1581 */         RasterRangesUtils.outputOccupiedRanges(param1Raster, new RasterRangesUtils.RangesOutput()
/*      */             {
/*      */               public boolean outputRange(int param2Int1, int param2Int2, int param2Int3, int param2Int4) {
/* 1584 */                 rlist.add(new Rectangle(param2Int1, param2Int2, param2Int3, param2Int4));
/* 1585 */                 return true;
/*      */               }
/*      */             });
/*      */         
/* 1589 */         X11.XRectangle[] arrayOfXRectangle = (X11.XRectangle[])(new X11.XRectangle()).toArray(arrayList.size()); byte b;
/* 1590 */         for (b = 0; b < arrayOfXRectangle.length; b++) {
/* 1591 */           Rectangle rectangle1 = arrayList.get(b);
/* 1592 */           (arrayOfXRectangle[b]).x = (short)rectangle1.x;
/* 1593 */           (arrayOfXRectangle[b]).y = (short)rectangle1.y;
/* 1594 */           (arrayOfXRectangle[b]).width = (short)rectangle1.width;
/* 1595 */           (arrayOfXRectangle[b]).height = (short)rectangle1.height;
/*      */           
/* 1597 */           Pointer pointer = arrayOfXRectangle[b].getPointer();
/* 1598 */           pointer.setShort(0L, (short)rectangle1.x);
/* 1599 */           pointer.setShort(2L, (short)rectangle1.y);
/* 1600 */           pointer.setShort(4L, (short)rectangle1.width);
/* 1601 */           pointer.setShort(6L, (short)rectangle1.height);
/* 1602 */           arrayOfXRectangle[b].setAutoSynch(false);
/*      */         } 
/*      */         
/* 1605 */         b = 1;
/* 1606 */         x11.XSetForeground(param1Display, gC, new NativeLong(1L));
/* 1607 */         x11.XFillRectangles(param1Display, (X11.Drawable)pixmap, gC, arrayOfXRectangle, arrayOfXRectangle.length);
/*      */       } finally {
/*      */         
/* 1610 */         x11.XFreeGC(param1Display, gC);
/*      */       } 
/* 1612 */       return pixmap;
/*      */     }
/*      */ 
/*      */     
/* 1616 */     private long[] alphaVisualIDs = new long[0]; private static final long OPAQUE = 4294967295L;
/*      */     private static final String OPACITY = "_NET_WM_WINDOW_OPACITY";
/*      */     
/*      */     public boolean isWindowAlphaSupported() {
/* 1620 */       return ((getAlphaVisualIDs()).length > 0);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static long getVisualID(GraphicsConfiguration param1GraphicsConfiguration) {
/*      */       try {
/* 1629 */         Object object = param1GraphicsConfiguration.getClass().getMethod("getVisual", (Class[])null).invoke(param1GraphicsConfiguration, (Object[])null);
/* 1630 */         return ((Number)object).longValue();
/*      */       }
/* 1632 */       catch (Exception exception) {
/*      */         
/* 1634 */         exception.printStackTrace();
/* 1635 */         return -1L;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public GraphicsConfiguration getAlphaCompatibleGraphicsConfiguration() {
/* 1642 */       if (isWindowAlphaSupported()) {
/*      */         
/* 1644 */         GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
/* 1645 */         GraphicsDevice[] arrayOfGraphicsDevice = graphicsEnvironment.getScreenDevices();
/* 1646 */         for (byte b = 0; b < arrayOfGraphicsDevice.length; b++) {
/*      */           
/* 1648 */           GraphicsConfiguration[] arrayOfGraphicsConfiguration = arrayOfGraphicsDevice[b].getConfigurations();
/* 1649 */           for (byte b1 = 0; b1 < arrayOfGraphicsConfiguration.length; b1++) {
/* 1650 */             long l = getVisualID(arrayOfGraphicsConfiguration[b1]);
/* 1651 */             long[] arrayOfLong = getAlphaVisualIDs();
/* 1652 */             for (byte b2 = 0; b2 < arrayOfLong.length; b2++) {
/* 1653 */               if (l == arrayOfLong[b2]) {
/* 1654 */                 return arrayOfGraphicsConfiguration[b1];
/*      */               }
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/* 1660 */       return super.getAlphaCompatibleGraphicsConfiguration();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private synchronized long[] getAlphaVisualIDs() {
/* 1668 */       if (this.didCheck) {
/* 1669 */         return this.alphaVisualIDs;
/*      */       }
/* 1671 */       this.didCheck = true;
/* 1672 */       X11 x11 = X11.INSTANCE;
/* 1673 */       X11.Display display = x11.XOpenDisplay(null);
/* 1674 */       if (display == null)
/* 1675 */         return this.alphaVisualIDs; 
/* 1676 */       X11.XVisualInfo xVisualInfo = null;
/*      */       try {
/* 1678 */         int i = x11.XDefaultScreen(display);
/* 1679 */         X11.XVisualInfo xVisualInfo1 = new X11.XVisualInfo();
/* 1680 */         xVisualInfo1.screen = i;
/* 1681 */         xVisualInfo1.depth = 32;
/* 1682 */         xVisualInfo1.c_class = 4;
/* 1683 */         NativeLong nativeLong = new NativeLong(14L);
/*      */ 
/*      */         
/* 1686 */         IntByReference intByReference = new IntByReference();
/* 1687 */         xVisualInfo = x11.XGetVisualInfo(display, nativeLong, xVisualInfo1, intByReference);
/* 1688 */         if (xVisualInfo != null) {
/* 1689 */           ArrayList<X11.VisualID> arrayList = new ArrayList();
/*      */           
/* 1691 */           X11.XVisualInfo[] arrayOfXVisualInfo = (X11.XVisualInfo[])xVisualInfo.toArray(intByReference.getValue()); byte b;
/* 1692 */           for (b = 0; b < arrayOfXVisualInfo.length; b++) {
/*      */             
/* 1694 */             X11.Xrender.XRenderPictFormat xRenderPictFormat = X11.Xrender.INSTANCE.XRenderFindVisualFormat(display, (arrayOfXVisualInfo[b]).visual);
/*      */             
/* 1696 */             if (xRenderPictFormat.type == 1 && xRenderPictFormat.direct.alphaMask != 0)
/*      */             {
/* 1698 */               arrayList.add((arrayOfXVisualInfo[b]).visualid);
/*      */             }
/*      */           } 
/* 1701 */           this.alphaVisualIDs = new long[arrayList.size()];
/* 1702 */           for (b = 0; b < this.alphaVisualIDs.length; b++) {
/* 1703 */             this.alphaVisualIDs[b] = ((Number)arrayList.get(b)).longValue();
/*      */           }
/* 1705 */           return this.alphaVisualIDs;
/*      */         } 
/*      */       } finally {
/*      */         
/* 1709 */         if (xVisualInfo != null) {
/* 1710 */           x11.XFree(xVisualInfo.getPointer());
/*      */         }
/* 1712 */         x11.XCloseDisplay(display);
/*      */       } 
/* 1714 */       return this.alphaVisualIDs;
/*      */     }
/*      */ 
/*      */     
/*      */     private static X11.Window getContentWindow(Window param1Window, X11.Display param1Display, X11.Window param1Window1, Point param1Point) {
/* 1719 */       if ((param1Window instanceof Frame && !((Frame)param1Window).isUndecorated()) || (param1Window instanceof Dialog && 
/* 1720 */         !((Dialog)param1Window).isUndecorated())) {
/* 1721 */         X11 x11 = X11.INSTANCE;
/* 1722 */         X11.WindowByReference windowByReference1 = new X11.WindowByReference();
/* 1723 */         X11.WindowByReference windowByReference2 = new X11.WindowByReference();
/* 1724 */         PointerByReference pointerByReference = new PointerByReference();
/* 1725 */         IntByReference intByReference = new IntByReference();
/* 1726 */         x11.XQueryTree(param1Display, param1Window1, windowByReference1, windowByReference2, pointerByReference, intByReference);
/* 1727 */         Pointer pointer = pointerByReference.getValue();
/* 1728 */         int[] arrayOfInt1 = pointer.getIntArray(0L, intByReference.getValue());
/* 1729 */         int arrayOfInt2[] = arrayOfInt1, i = arrayOfInt2.length; byte b = 0; if (b < i) { int j = arrayOfInt2[b];
/*      */           
/* 1731 */           X11.Window window = new X11.Window(j);
/* 1732 */           X11.XWindowAttributes xWindowAttributes = new X11.XWindowAttributes();
/* 1733 */           x11.XGetWindowAttributes(param1Display, window, xWindowAttributes);
/* 1734 */           param1Point.x = -xWindowAttributes.x;
/* 1735 */           param1Point.y = -xWindowAttributes.y;
/* 1736 */           param1Window1 = window; }
/*      */ 
/*      */         
/* 1739 */         if (pointer != null) {
/* 1740 */           x11.XFree(pointer);
/*      */         }
/*      */       } 
/* 1743 */       return param1Window1;
/*      */     }
/*      */     
/*      */     private static X11.Window getDrawable(Component param1Component) {
/* 1747 */       int i = (int)Native.getComponentID(param1Component);
/* 1748 */       if (i == 0)
/* 1749 */         return null; 
/* 1750 */       return new X11.Window(i);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setWindowAlpha(final Window w, final float alpha) {
/* 1758 */       if (!isWindowAlphaSupported()) {
/* 1759 */         throw new UnsupportedOperationException("This X11 display does not provide a 32-bit visual");
/*      */       }
/* 1761 */       Runnable runnable = new Runnable()
/*      */         {
/*      */           public void run() {
/* 1764 */             X11 x11 = X11.INSTANCE;
/* 1765 */             X11.Display display = x11.XOpenDisplay(null);
/* 1766 */             if (display == null)
/*      */               return; 
/*      */             try {
/* 1769 */               X11.Window window = WindowUtils.X11WindowUtils.getDrawable(w);
/* 1770 */               if (alpha == 1.0F) {
/* 1771 */                 x11.XDeleteProperty(display, window, x11
/* 1772 */                     .XInternAtom(display, "_NET_WM_WINDOW_OPACITY", false));
/*      */               }
/*      */               else {
/*      */                 
/* 1776 */                 int i = (int)((long)(alpha * 4.2949673E9F) & 0xFFFFFFFFFFFFFFFFL);
/* 1777 */                 IntByReference intByReference = new IntByReference(i);
/* 1778 */                 x11.XChangeProperty(display, window, x11
/* 1779 */                     .XInternAtom(display, "_NET_WM_WINDOW_OPACITY", false), X11.XA_CARDINAL, 32, 0, intByReference
/*      */ 
/*      */ 
/*      */                     
/* 1783 */                     .getPointer(), 1);
/*      */               } 
/*      */             } finally {
/*      */               
/* 1787 */               x11.XCloseDisplay(display);
/*      */             } 
/*      */           }
/*      */         };
/* 1791 */       whenDisplayable(w, runnable);
/*      */     }
/*      */     private class X11TransparentContentPane extends WindowUtils.NativeWindowUtils.TransparentContentPane { private static final long serialVersionUID = 1L; private Memory buffer;
/*      */       private int[] pixels;
/*      */       private final int[] pixel;
/*      */       
/*      */       public X11TransparentContentPane(Container param2Container) {
/* 1798 */         super(param2Container);
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1803 */         this.pixel = new int[4];
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       protected void paintDirect(BufferedImage param2BufferedImage, Rectangle param2Rectangle) {
/* 1809 */         Window window = SwingUtilities.getWindowAncestor(this);
/* 1810 */         X11 x11 = X11.INSTANCE;
/* 1811 */         X11.Display display = x11.XOpenDisplay(null);
/* 1812 */         X11.Window window1 = WindowUtils.X11WindowUtils.getDrawable(window);
/* 1813 */         Point point = new Point();
/* 1814 */         window1 = WindowUtils.X11WindowUtils.getContentWindow(window, display, window1, point);
/* 1815 */         X11.GC gC = x11.XCreateGC(display, (X11.Drawable)window1, new NativeLong(0L), null);
/*      */         
/* 1817 */         Raster raster = param2BufferedImage.getData();
/* 1818 */         int i = param2Rectangle.width;
/* 1819 */         int j = param2Rectangle.height;
/* 1820 */         if (this.buffer == null || this.buffer.size() != (i * j * 4)) {
/* 1821 */           this.buffer = new Memory((i * j * 4));
/* 1822 */           this.pixels = new int[i * j];
/*      */         } 
/* 1824 */         for (byte b = 0; b < j; b++) {
/* 1825 */           for (byte b1 = 0; b1 < i; b1++) {
/* 1826 */             raster.getPixel(b1, b, this.pixel);
/* 1827 */             int k = this.pixel[3] & 0xFF;
/* 1828 */             int m = this.pixel[2] & 0xFF;
/* 1829 */             int n = this.pixel[1] & 0xFF;
/* 1830 */             int i1 = this.pixel[0] & 0xFF;
/*      */ 
/*      */             
/* 1833 */             this.pixels[b * i + b1] = k << 24 | i1 << 16 | n << 8 | m;
/*      */           } 
/*      */         } 
/* 1836 */         X11.XWindowAttributes xWindowAttributes = new X11.XWindowAttributes();
/* 1837 */         x11.XGetWindowAttributes(display, window1, xWindowAttributes);
/*      */         
/* 1839 */         X11.XImage xImage = x11.XCreateImage(display, xWindowAttributes.visual, 32, 2, 0, (Pointer)this.buffer, i, j, 32, i * 4);
/*      */         
/* 1841 */         this.buffer.write(0L, this.pixels, 0, this.pixels.length);
/* 1842 */         point.x += param2Rectangle.x;
/* 1843 */         point.y += param2Rectangle.y;
/* 1844 */         x11.XPutImage(display, (X11.Drawable)window1, gC, xImage, 0, 0, point.x, point.y, i, j);
/*      */         
/* 1846 */         x11.XFree(xImage.getPointer());
/* 1847 */         x11.XFreeGC(display, gC);
/* 1848 */         x11.XCloseDisplay(display);
/*      */       } }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setWindowTransparent(final Window w, final boolean transparent) {
/* 1855 */       if (!(w instanceof RootPaneContainer)) {
/* 1856 */         throw new IllegalArgumentException("Window must be a RootPaneContainer");
/*      */       }
/* 1858 */       if (!isWindowAlphaSupported()) {
/* 1859 */         throw new UnsupportedOperationException("This X11 display does not provide a 32-bit visual");
/*      */       }
/*      */       
/* 1862 */       if (!w.getGraphicsConfiguration().equals(getAlphaCompatibleGraphicsConfiguration())) {
/* 1863 */         throw new IllegalArgumentException("Window GraphicsConfiguration '" + w.getGraphicsConfiguration() + "' does not support transparency");
/*      */       }
/*      */       
/* 1866 */       boolean bool = (w.getBackground() != null && w.getBackground().getAlpha() == 0);
/* 1867 */       if (transparent == bool)
/*      */         return; 
/* 1869 */       whenDisplayable(w, new Runnable()
/*      */           {
/*      */             public void run() {
/* 1872 */               JRootPane jRootPane = ((RootPaneContainer)w).getRootPane();
/* 1873 */               JLayeredPane jLayeredPane = jRootPane.getLayeredPane();
/* 1874 */               Container container = jRootPane.getContentPane();
/* 1875 */               if (container instanceof WindowUtils.X11WindowUtils.X11TransparentContentPane) {
/* 1876 */                 ((WindowUtils.X11WindowUtils.X11TransparentContentPane)container).setTransparent(transparent);
/*      */               }
/* 1878 */               else if (transparent) {
/* 1879 */                 WindowUtils.X11WindowUtils.X11TransparentContentPane x11TransparentContentPane = new WindowUtils.X11WindowUtils.X11TransparentContentPane(container);
/*      */                 
/* 1881 */                 jRootPane.setContentPane(x11TransparentContentPane);
/* 1882 */                 jLayeredPane.add(new WindowUtils.RepaintTrigger(x11TransparentContentPane), JLayeredPane.DRAG_LAYER);
/*      */               } 
/*      */               
/* 1885 */               WindowUtils.X11WindowUtils.this.setLayersTransparent(w, transparent);
/* 1886 */               WindowUtils.X11WindowUtils.this.setForceHeavyweightPopups(w, transparent);
/* 1887 */               WindowUtils.X11WindowUtils.this.setDoubleBuffered(w, !transparent);
/*      */             }
/*      */           });
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void setWindowShape(final Window w, final PixmapSource src) {
/* 1897 */       Runnable runnable = new Runnable()
/*      */         {
/*      */           public void run() {
/* 1900 */             X11 x11 = X11.INSTANCE;
/* 1901 */             X11.Display display = x11.XOpenDisplay(null);
/* 1902 */             if (display == null) {
/*      */               return;
/*      */             }
/* 1905 */             X11.Pixmap pixmap = null;
/*      */             try {
/* 1907 */               X11.Window window = WindowUtils.X11WindowUtils.getDrawable(w);
/* 1908 */               pixmap = src.getPixmap(display, window);
/* 1909 */               X11.Xext xext = X11.Xext.INSTANCE;
/* 1910 */               xext.XShapeCombineMask(display, window, 0, 0, 0, (pixmap == null) ? X11.Pixmap.None : pixmap, 0);
/*      */             
/*      */             }
/*      */             finally {
/*      */               
/* 1915 */               if (pixmap != null) {
/* 1916 */                 x11.XFreePixmap(display, pixmap);
/*      */               }
/* 1918 */               x11.XCloseDisplay(display);
/*      */             } 
/* 1920 */             WindowUtils.X11WindowUtils.this.setForceHeavyweightPopups(WindowUtils.X11WindowUtils.this.getWindow(w), (pixmap != null));
/*      */           }
/*      */         };
/* 1923 */       whenDisplayable(w, runnable);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void setMask(Component param1Component, final Raster raster) {
/* 1928 */       setWindowShape(getWindow(param1Component), new PixmapSource()
/*      */           {
/*      */             public X11.Pixmap getPixmap(X11.Display param2Display, X11.Window param2Window) {
/* 1931 */               return (raster != null) ? WindowUtils.X11WindowUtils.createBitmap(param2Display, param2Window, raster) : null;
/*      */             }
/*      */           });
/*      */     }
/*      */     
/*      */     private X11WindowUtils() {}
/*      */     
/*      */     private static interface PixmapSource {
/*      */       X11.Pixmap getPixmap(X11.Display param2Display, X11.Window param2Window); }
/*      */   }
/*      */   
/*      */   public static void setWindowMask(Window paramWindow, Shape paramShape) {
/* 1943 */     getInstance().setWindowMask(paramWindow, paramShape);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void setComponentMask(Component paramComponent, Shape paramShape) {
/* 1952 */     getInstance().setWindowMask(paramComponent, paramShape);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void setWindowMask(Window paramWindow, Icon paramIcon) {
/* 1961 */     getInstance().setWindowMask(paramWindow, paramIcon);
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean isWindowAlphaSupported() {
/* 1966 */     return getInstance().isWindowAlphaSupported();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static GraphicsConfiguration getAlphaCompatibleGraphicsConfiguration() {
/* 1974 */     return getInstance().getAlphaCompatibleGraphicsConfiguration();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void setWindowAlpha(Window paramWindow, float paramFloat) {
/* 1992 */     getInstance().setWindowAlpha(paramWindow, Math.max(0.0F, Math.min(paramFloat, 1.0F)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void setWindowTransparent(Window paramWindow, boolean paramBoolean) {
/* 2008 */     getInstance().setWindowTransparent(paramWindow, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BufferedImage getWindowIcon(WinDef.HWND paramHWND) {
/* 2021 */     return getInstance().getWindowIcon(paramHWND);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Dimension getIconSize(WinDef.HICON paramHICON) {
/* 2033 */     return getInstance().getIconSize(paramHICON);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<DesktopWindow> getAllWindows(boolean paramBoolean) {
/* 2051 */     return getInstance().getAllWindows(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getWindowTitle(WinDef.HWND paramHWND) {
/* 2064 */     return getInstance().getWindowTitle(paramHWND);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getProcessFilePath(WinDef.HWND paramHWND) {
/* 2078 */     return getInstance().getProcessFilePath(paramHWND);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Rectangle getWindowLocationAndSize(WinDef.HWND paramHWND) {
/* 2090 */     return getInstance().getWindowLocationAndSize(paramHWND);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\WindowUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */