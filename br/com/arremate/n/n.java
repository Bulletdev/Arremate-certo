/*      */ package br.com.arremate.n;
/*      */ 
/*      */ import br.com.arremate.a.a.c;
/*      */ import br.com.arremate.a.g;
/*      */ import br.com.arremate.a.i;
/*      */ import br.com.arremate.c.c;
/*      */ import br.com.arremate.c.d;
/*      */ import br.com.arremate.d.b;
/*      */ import br.com.arremate.d.g;
/*      */ import br.com.arremate.e.a;
/*      */ import br.com.arremate.f.e;
/*      */ import br.com.arremate.f.l;
/*      */ import br.com.arremate.f.m;
/*      */ import br.com.arremate.f.o;
/*      */ import br.com.arremate.f.t;
/*      */ import br.com.arremate.f.u;
/*      */ import br.com.arremate.f.z;
/*      */ import br.com.arremate.j.i;
/*      */ import br.com.arremate.k.c.c;
/*      */ import br.com.arremate.l.a.b;
/*      */ import br.com.arremate.l.b.b;
/*      */ import br.com.arremate.l.c.b;
/*      */ import br.com.arremate.l.d;
/*      */ import br.com.arremate.l.d.b;
/*      */ import br.com.arremate.l.e.c;
/*      */ import br.com.arremate.l.e.d;
/*      */ import br.com.arremate.l.e.f;
/*      */ import br.com.arremate.l.f.b;
/*      */ import br.com.arremate.l.g.b;
/*      */ import br.com.arremate.l.h.b;
/*      */ import br.com.arremate.l.i.b;
/*      */ import br.com.arremate.l.j;
/*      */ import br.com.arremate.l.j.b;
/*      */ import br.com.arremate.l.k.c;
/*      */ import br.com.arremate.l.l.b;
/*      */ import br.com.arremate.l.m.b;
/*      */ import br.com.arremate.l.m.c;
/*      */ import br.com.arremate.l.m.d;
/*      */ import br.com.arremate.l.n.b;
/*      */ import br.com.arremate.l.o.b;
/*      */ import br.com.arremate.l.p.f;
/*      */ import br.com.arremate.l.p.j;
/*      */ import br.com.arremate.l.q.b.h;
/*      */ import br.com.arremate.l.q.b.i;
/*      */ import br.com.arremate.m.A;
/*      */ import br.com.arremate.m.a;
/*      */ import br.com.arremate.m.g;
/*      */ import br.com.arremate.m.j;
/*      */ import br.com.arremate.m.l;
/*      */ import br.com.arremate.m.y;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.Font;
/*      */ import java.awt.Toolkit;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.event.MouseMotionAdapter;
/*      */ import java.awt.event.WindowAdapter;
/*      */ import java.awt.event.WindowEvent;
/*      */ import java.awt.font.TextAttribute;
/*      */ import java.awt.image.BufferedImage;
/*      */ import java.io.ByteArrayInputStream;
/*      */ import java.io.File;
/*      */ import java.sql.CallableStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.sql.Statement;
/*      */ import java.sql.Timestamp;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Calendar;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.StringJoiner;
/*      */ import java.util.Timer;
/*      */ import java.util.TimerTask;
/*      */ import java.util.concurrent.Executors;
/*      */ import java.util.concurrent.Future;
/*      */ import java.util.concurrent.ScheduledExecutorService;
/*      */ import java.util.concurrent.ScheduledThreadPoolExecutor;
/*      */ import java.util.concurrent.ThreadPoolExecutor;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import javax.imageio.ImageIO;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JDialog;
/*      */ import javax.swing.JFrame;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JMenu;
/*      */ import javax.swing.JMenuBar;
/*      */ import javax.swing.JMenuItem;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPopupMenu;
/*      */ import javax.swing.JTabbedPane;
/*      */ import javax.swing.KeyStroke;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.event.ChangeEvent;
/*      */ import javax.swing.event.ChangeListener;
/*      */ import org.apache.commons.codec.binary.Base64;
/*      */ import org.apache.commons.lang3.StringUtils;
/*      */ import org.e.f;
/*      */ import org.e.i;
/*      */ import org.jsoup.Jsoup;
/*      */ import org.jsoup.nodes.Document;
/*      */ import org.jsoup.nodes.Element;
/*      */ import org.slf4j.Logger;
/*      */ import org.slf4j.LoggerFactory;
/*      */ 
/*      */ public final class n extends JFrame {
/*  119 */   private static final Logger a = LoggerFactory.getLogger(n.class);
/*      */   
/*  121 */   public static String fM = "";
/*  122 */   public static String fN = ""; private static n b; private final Object g; private final Calendar g; private Runnable b; private boolean ar; private ScheduledExecutorService e; private JTabbedPane c; private JLabel bh; private JLabel bi; private JLabel bj; private JLabel bk; private JLabel bl; private JMenu a; private JMenu b; private JMenu c; private JMenuItem a; private JMenuBar a; private JMenu d; private JMenuItem b; private JMenuItem c; private JMenuItem d; private JMenuItem e; private JMenuItem f; private JMenuItem g; private JMenuItem h; private JMenuItem i; private JMenuItem j; private JMenuItem k; private JMenuItem l; private JMenuItem m; private JMenuItem n; private JMenuItem o; private JMenuItem p; private JMenuItem q; private JMenuItem r; private JMenuItem s; private JMenuItem t; private JMenuItem u; private JMenu e; private JMenuItem v; private JMenuItem w; private JPopupMenu.Separator a;
/*      */   private JPopupMenu.Separator b;
/*      */   private JMenu f;
/*  125 */   private JMenu g = (JMenu)new Object();
/*      */   
/*  127 */   private n() { this.g = (JMenu)Calendar.getInstance();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1094 */     this.ar = false; a.info("Inicializa tela principal"); k(); if (!br.com.arremate.m.n.bU()) this.d.setVisible(false);  dN(); dO(); dP(); dS(); dT(); dV(); dH(); dW(); dX(); addWindowListener(new WindowAdapter(this) {
/*      */           public void windowClosing(WindowEvent param1WindowEvent) { this.c.dM(); }
/*      */         }); setFocusable(true); setLocationRelativeTo((Component)null); Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize(); if (dimension.getHeight() > getHeight() && dimension.getWidth() > getWidth()) { setExtendedState(6); setResizable(true); }  this.bh.setVisible(false); }
/*      */   public static n a() { if (b == null) b = (JPopupMenu.Separator)new n();  return (n)b; }
/*      */   public void start() { de(); setVisible(true); dU(); dG(); }
/*      */   private void dF() { boolean bool = true; if (!y.l(fM)) { JOptionPane.showMessageDialog(this, "Não foi possível abrir o atendimento", "Erro", 0); bool = false; }  j.a().P(bool); }
/* 1100 */   private void dG() { try (Statement null = a.a().createStatement()) { String str = "SELECT COUNT(*) AS qtd FROM tbempresa WHERE empativo = true"; try (ResultSet null = statement.executeQuery(str)) { if (resultSet.next() && resultSet.getInt("qtd") == 0) D((ActionEvent)null);  }  } catch (Exception exception) { a.warn("Falha ao verificar quantidade de empresas cadastradas", exception); }  } private void dH() { if (br.com.arremate.m.n.bW()) { dI(); d.a(this.e); } else { this.e.setVisible(false); this.q.setVisible(false); }  } private void de() { try (Statement null = a.a().createStatement()) { String str = "SELECT empcnpj, liccodigo, licnumero, licuasg, licuasgnome, licsrp, licunitario, licdataabertura, porcodigo, liccriterio, lichash, licdataencerramento, lictipoapuracao, licicms, licmododedisputa, licpreclosingtime, licclosingtime, licmodalidade, liclimitecasasdecimais, licmunicipio FROM tblicitacao WHERE licoculta = false ORDER BY licdataabertura, empcnpj, liccodigo"; ResultSet resultSet = statement.executeQuery(str); while (resultSet.next()) { f f = null; br.com.arremate.l.n n1 = l.a().a(resultSet.getInt("porcodigo")); if (n1 != null && n1.getStatus() != br.com.arremate.l.n.aW) { d d2; d d1; c c2; b b12; c c1; b b11; b b10; b b9; b b8; b b7; b b6; b b5; b b4; b b3; b b2; b b1; b b; d d3; Timestamp timestamp; d d4; c c3; c c4; b b13; b b14; b b15; b b16; d d = g.a(n1, resultSet.getLong("empcnpj")); int i = resultSet.getInt("liccodigo"); switch (null.g[n1.a().ordinal()]) { case 1: f = new f(d, i); f.D(resultSet.getBoolean("licicms")); break;case 2: case 3: if (n1.a().equals(o.a)) { c c = new c(d, i); } else { d3 = new d(d, i); }  d3.D(resultSet.getBoolean("licicms")); timestamp = resultSet.getTimestamp("licdataencerramento"); if (timestamp != null) { Calendar calendar = Calendar.getInstance(); calendar.setTime(timestamp); d3.a(calendar); }  d2 = d3; break;case 4: d1 = new d(d, i); d4 = d1; d4.aA(resultSet.getString("lichash")); d4.a(m.a(resultSet.getInt("licmododedisputa"))); d4.a(u.a(resultSet.getInt("lictipoapuracao"))); break;case 5: c2 = new c(d, i); c3 = c2; c3.aA(resultSet.getString("lichash")); c3.a(u.a(resultSet.getInt("lictipoapuracao"))); break;case 6: b12 = new b(d, i); break;case 7: c1 = new c(d, i); c4 = c1; c4.a(e.a(resultSet.getString("liccriterio"))); c4.aA(resultSet.getString("lichash")); break;case 8: b11 = new b(d, i); b11.a(u.a(resultSet.getInt("lictipoapuracao"))); break;case 9: b10 = new b(d, i); b10.a(u.a(resultSet.getInt("lictipoapuracao"))); b10.D(resultSet.getBoolean("licicms")); break;case 10: b9 = new b(d, i); break;case 11: b8 = new b(d, i); b8.a(u.a(resultSet.getInt("lictipoapuracao"))); break;case 12: b7 = new b(d, i); break;case 13: b6 = new b(d, i); b6.a(u.a(resultSet.getInt("lictipoapuracao"))); break;case 14: b5 = new b(d, i); b13 = b5; b13.aA(resultSet.getString("lichash")); b13.a(u.a(resultSet.getInt("lictipoapuracao"))); break;case 15: b4 = new b(d, i); b14 = b4; b14.aA(resultSet.getString("lichash")); break;case 16: b3 = new b(d, i); b15 = b3; b15.W(resultSet.getInt("licpreclosingtime")); b15.X(resultSet.getInt("licclosingtime")); break;case 17: b2 = new b(d, i); b16 = b2; b16.W(resultSet.getInt("licpreclosingtime")); b16.X(resultSet.getInt("licclosingtime")); break;case 18: b1 = new b(d, i); break;case 19: b = new b(d, i); break; }  if (b != null) { b.Q(resultSet.getInt("licuasg")); b.aw(resultSet.getString("licuasgnome")); b.T(resultSet.getString("licnumero")); b.s(resultSet.getBoolean("licsrp")); b.z(resultSet.getBoolean("licunitario")); Calendar calendar = Calendar.getInstance(); calendar.setTime(resultSet.getTimestamp("licdataabertura")); b.b(calendar); b.a(m.a(resultSet.getInt("licmododedisputa"))); b.a(l.b(resultSet.getInt("licmodalidade"))); b.Y(resultSet.getInt("liclimitecasasdecimais")); b.az(resultSet.getString("licmunicipio")); c((j)b, false); }  }  }  } catch (Exception exception) { a.error("Falha ao carregar pregões", exception); }  } private void dI() { try (Statement null = a.a().createStatement()) { String str = "SELECT tblicitacao.empcnpj, tblicitacao.liccodigo, tblicitacao.licnumero, tblicitacao.licdataabertura, tblicitacao.licdataencerramento, tblicitacao.licuasg, tblicitacao.licsrp, tblicitacao.lichash, tblicitacao.licuasgnome, tblicitacao.liccriterio, tblicitacao.porcodigo, tblicitacao.licicms, tblicitacao.lictipoapuracao,  tblicitacao.licpreclosingtime, tblicitacao.licclosingtime FROM tblicitacao INNER JOIN tbempresa ON tbempresa.empcnpj = tblicitacao.empcnpj AND tbempresa.porcodigo = tblicitacao.porcodigo WHERE tblicitacao.licoculta IS TRUE ORDER BY tblicitacao.liccodigo"; ResultSet resultSet = statement.executeQuery(str); while (resultSet.next()) { d d1; c c1; c c; d d; b b7; b b6; b b5; b b4; b b3; b b2; b b; b b1; Timestamp timestamp; c c3; b b8; b b9; c c2 = null; br.com.arremate.l.n n1 = l.a().a(resultSet.getInt("porcodigo")); if (n1 == null) return;  d d2 = g.a(n1, resultSet.getLong("empcnpj")); int i = resultSet.getInt("liccodigo"); switch (null.g[n1.a().ordinal()]) { case 2: c2 = new c(d2, i); c2.D(resultSet.getBoolean("licicms")); break;case 3: d1 = new d(d2, i); timestamp = resultSet.getTimestamp("licdataencerramento"); if (timestamp != null) { Calendar calendar = Calendar.getInstance(); calendar.setTime(timestamp); d1.a(calendar); }  break;case 7: c1 = new c(d2, i); c3 = c1; c3.a(e.a(resultSet.getString("liccriterio"))); c3.aA(resultSet.getString("lichash")); break;case 5: c = new c(d2, i); c.aA(resultSet.getString("lichash")); break;case 4: d = new d(d2, i); d.aA(resultSet.getString("lichash")); break;case 8: b7 = new b(d2, i); b7.a(u.a(resultSet.getInt("lictipoapuracao"))); break;case 9: b6 = new b(d2, i); b6.a(u.a(resultSet.getInt("lictipoapuracao"))); break;case 10: b5 = new b(d2, i); break;case 12: b4 = new b(d2, i); break;case 6: b3 = new b(d2, i); break;case 14: b2 = new b(d2, i); b8 = b2; b8.aA(resultSet.getString("lichash")); b8.a(u.a(resultSet.getInt("lictipoapuracao"))); break;case 15: b = new b(d2, i); break;case 16: b1 = new b(d2, i); b9 = b1; b9.W(resultSet.getInt("licpreclosingtime")); b9.X(resultSet.getInt("licclosingtime")); break; }  if (b1 != null) { Calendar calendar = Calendar.getInstance(); calendar.setTime(resultSet.getTimestamp("licdataabertura")); b1.T(resultSet.getString("licnumero")); b1.Q(resultSet.getInt("licuasg")); b1.aw(resultSet.getString("licuasgnome")); b1.b(calendar); b1.s(resultSet.getBoolean("licsrp")); s((j)b1); }  }  } catch (Exception exception) { a.warn("Falha ao carregar pregões ocultos", exception); }  } public void r(j paramj) { c(paramj, true); } private void dK() { HashSet hashSet; synchronized (this.g) {
/* 1101 */       if (this.c.getTabCount() <= 0) {
/* 1102 */         JOptionPane.showMessageDialog(null, "Nenhum pregão para ser removido!", "Informativo", 1);
/*      */         
/*      */         return;
/*      */       } 
/*      */     } 
/* 1107 */     if (this.ar) {
/* 1108 */       JOptionPane.showMessageDialog(null, "Já existe uma solicitação para remover pregões encerrados em andamento!", "Informativo", 1);
/*      */       
/*      */       return;
/*      */     } 
/* 1112 */     this.ar = true;
/*      */ 
/*      */     
/* 1115 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 1116 */     ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(5);
/* 1117 */     ArrayList<Future<?>> arrayList = new ArrayList();
/* 1118 */     StringJoiner stringJoiner1 = new StringJoiner("\n");
/* 1119 */     StringJoiner stringJoiner2 = new StringJoiner("\n");
/*      */ 
/*      */     
/* 1122 */     synchronized (this.g) {
/* 1123 */       hashSet = new HashSet(Arrays.asList((Object[])this.c.getComponents()));
/*      */     } 
/*      */ 
/*      */     
/* 1127 */     int i = hashSet.size();
/* 1128 */     this.bh.setText(String.join("", new CharSequence[] { "Verificando a situação dos pregões para a exclusão: 0 de ", Integer.toString(i) }));
/* 1129 */     this.bh.setIcon(new ImageIcon(getClass().getResource("/img/loading-blue.gif")));
/* 1130 */     this.bh.setVisible(true);
/*      */     
/* 1132 */     for (Iterator<Component> iterator = hashSet.iterator(); iterator.hasNext(); ) { Component component = iterator.next();
/* 1133 */       if (component instanceof b) {
/* 1134 */         b b = (b)component;
/* 1135 */         if (b.q()) {
/*      */           continue;
/*      */         }
/*      */         
/* 1139 */         j j = b.a();
/* 1140 */         d d = j.a();
/*      */         
/* 1142 */         if (!d.aO()) {
/* 1143 */           synchronized (stringJoiner1) {
/* 1144 */             stringJoiner1.add(
/* 1145 */                 String.join("", new CharSequence[] { "Não foi possível realizar login para a disputa \"", j.bX(), "\" do portal \"", d
/* 1146 */                     .b().K(), "\" porque o login encontra-se inativo." }));
/*      */           } 
/*      */         }
/*      */ 
/*      */         
/* 1151 */         arrayList.add(scheduledThreadPoolExecutor.submit(() -> {
/*      */                 try {
/*      */                   i i = null;
/*      */                   
/*      */                   synchronized (paramHashMap) {
/*      */                     String str = paramd.b().a().N();
/*      */                     
/*      */                     HashMap<Object, Object> hashMap = (HashMap)paramHashMap.get(str);
/*      */                     
/*      */                     if (hashMap != null) {
/*      */                       i = (i)hashMap.get(Long.valueOf(paramd.x()));
/*      */                     }
/*      */                     
/*      */                     if (i == null) {
/*      */                       Future<i> future = c.a(paramj);
/*      */                       
/*      */                       i = future.get();
/*      */                       
/*      */                       if (hashMap == null) {
/*      */                         hashMap = new HashMap<>();
/*      */                         
/*      */                         paramHashMap.put(str, hashMap);
/*      */                       } 
/*      */                       hashMap.put(Long.valueOf(paramd.x()), i);
/*      */                     } 
/*      */                   } 
/*      */                   if (i.isRunning()) {
/*      */                     g g = paramb.a().b(paramb, i);
/*      */                     if (g.a() == t.d) {
/*      */                       paramj.delete();
/*      */                       synchronized (this.g) {
/*      */                         try {
/*      */                           this.c.remove((Component)paramb);
/* 1184 */                         } catch (Exception exception) {
/*      */                           a.warn("Cnpj {}, Number {}, Uasg - Failed to remove bidding tab", new Object[] { Long.valueOf(paramj.C()), paramj.bo(), Integer.valueOf(paramj.K()) });
/*      */                         } 
/*      */                       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                       
/*      */                       paramStringJoiner1.add(String.join("", new CharSequence[] { "Licitação ", paramj.bX(), "   |   Portal ", paramd.b().K(), "   |   Empresa ", paramd.bv() }));
/*      */                     } 
/*      */                   } else {
/*      */                     synchronized (paramStringJoiner2) {
/*      */                       paramStringJoiner2.add(String.join("", new CharSequence[] { "Não foi possível realizar login para a disputa \"", paramj.bX(), "\" do portal \"", paramd.b().K(), "\" para verificar se o pregão encontra-se encerrado." }));
/*      */                     } 
/*      */                   } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*      */                   this.bh.setText(String.join("", new CharSequence[] { "Verificando a situação dos pregões para a exclusão: ", Long.toString(paramThreadPoolExecutor.getCompletedTaskCount()), " de ", Integer.toString(paramInt) }));
/* 1210 */                 } catch (Exception exception) {
/*      */                   a.error("Falha ao remover pregão com disputa encerrada", exception);
/*      */                 } 
/*      */               }));
/*      */       }  }
/*      */ 
/*      */     
/* 1217 */     (new Thread(() -> {
/*      */           try {
/*      */             for (Future future : paramList) {
/*      */               future.get();
/*      */             }
/* 1222 */           } catch (Exception exception) {}
/*      */ 
/*      */           
/*      */           this.bh.setText(String.join("", new CharSequence[] { "Verificando a situação dos pregões para a exclusão: ", Integer.toString(paramInt), " de ", Integer.toString(paramInt) }));
/*      */ 
/*      */           
/*      */           paramThreadPoolExecutor.shutdown();
/*      */ 
/*      */           
/*      */           if (paramStringJoiner1.length() > 0) {
/*      */             JOptionPane.showMessageDialog(null, String.join("", new CharSequence[] { "Erro(s) ao remover pregões:\n\n", paramStringJoiner1.toString() }), "Erro", 0);
/*      */           } else if (paramStringJoiner2.length() > 0) {
/*      */             JOptionPane.showMessageDialog(null, String.join("", new CharSequence[] { "Pregão(ões) com disputa encerrada removido(s) com sucesso:\n\n", paramStringJoiner2.toString() }), "Sucesso", 1);
/*      */           } else {
/*      */             JOptionPane.showMessageDialog(null, "Nenhum pregão encerrado para ser removido!", "Informativo", 1);
/*      */           } 
/*      */           
/*      */           this.ar = false;
/*      */           
/*      */           this.bh.setVisible(false);
/*      */           
/*      */           for (Map.Entry entry : paramHashMap.entrySet()) {
/*      */             for (Map.Entry entry1 : ((HashMap)entry.getValue()).entrySet()) {
/*      */               ((i)entry1.getValue()).b();
/*      */             }
/*      */           } 
/* 1248 */         })).start(); } private void c(j paramj, boolean paramBoolean) { synchronized (this.g) { b b = paramj.b(); if (b == null) return;  if (paramBoolean && this.c.getTabCount() > 0) for (byte b1 = 0; b1 < this.c.getTabCount(); b1++) { Component component = this.c.getComponentAt(b1); if (component instanceof b) { j j1 = ((b)component).a(); Calendar calendar1 = j1.h(); Calendar calendar2 = paramj.h(); if (!calendar1.before(calendar2) && (!calendar1.equals(calendar2) || j1.v() >= paramj.v() || j1.C() >= paramj.a().x())) { this.c.add((Component)b, b1); this.c.setTitleAt(b1, b.a().getTitle()); this.c.setSelectedComponent((Component)b); return; }  }  }   this.c.add(b.a().getTitle(), (Component)b); this.c.setSelectedComponent((Component)b); }  } public void s(j paramj) { String str = y.k("##.###.###/####-##", String.valueOf(paramj.C())); StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append(paramj.b().a().N()).append(" >> ").append("CNPJ: ").append(str).append(" - Abertura: ").append(paramj.bS()).append(" - Pregão: "); switch (null.g[paramj.b().a().ordinal()]) { case 2: stringBuilder.append(paramj.bo()).append(" - ").append(paramj.K()); break;case 3: stringBuilder.append(paramj.bo()).append(" - ").append(paramj.K()); break;case 9: stringBuilder.append(paramj.v()); break;case 6: stringBuilder.append(paramj.v());case 7: stringBuilder.append(paramj.K()).append(" ").append(paramj.bo()); break;case 5: stringBuilder.append(paramj.bo()).append(" ").append(paramj.v()); break;case 4: stringBuilder.append(paramj.bo()).append(" ").append(paramj.v()); break;case 10: case 12: stringBuilder.append(paramj.bo()); break; }  stringBuilder.append(" - ").append(paramj.bT()); JMenuItem jMenuItem = new JMenuItem(stringBuilder.toString()); jMenuItem.addActionListener(paramActionEvent -> { if (b(paramj)) this.e.remove(paramJMenuItem);  }); this.e.add(jMenuItem); } public boolean b(j paramj) { try (Statement null = a.a().createStatement()) { StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("UPDATE TBLICITACAO"); stringBuilder.append(" SET LICOCULTA = false"); stringBuilder.append(" WHERE EMPCNPJ = ").append(paramj.C()); stringBuilder.append(" AND LICCODIGO = ").append(paramj.v()); stringBuilder.append(" AND PORCODIGO = ").append(paramj.b().v()); if (statement.executeUpdate(stringBuilder.toString()) == 1) { r(paramj); return true; }  JOptionPane.showMessageDialog(null, "Erro ao restaurar exibição do pregão", "Mensagem", 0); } catch (Exception exception) { a.warn("Erro ao restaurar exibição do pregão", exception); }  return false; } private void k() { this.d = new JMenuItem(); this.c = (JMenuItem)new JTabbedPane(this) { private Dimension a() { Dimension dimension = this.c.getContentPane().getSize(); double d = dimension.getSize().getHeight(); d -= n.a(this.c).getSize().getHeight(); d -= n.a(this.c).getSize().getHeight(); return new Dimension((int)dimension.getSize().getWidth(), (int)d); } public Dimension getSize() { return a(); } public Dimension getPreferredSize() { return a(); } public Dimension getMinimumSize() { return a(); } public Dimension getMaximumSize() { return a(); } }
/*      */       ; this.bj = new JLabel(); this.bk = new JLabel(); this.bl = new JLabel(); this.bi = new JLabel(); this.bh = new JLabel(); this.a = (JPopupMenu.Separator)new JMenuBar(); this.a = (JPopupMenu.Separator)new JMenu(); this.a = (JPopupMenu.Separator)new JMenuItem(); this.c = new JMenuItem(); this.s = new JMenuItem(); this.g = (JMenu)new JMenuItem(); this.a = new JPopupMenu.Separator(); this.u = new JMenuItem(); this.e = new JMenu(); this.c = new JMenu(); this.o = new JMenuItem(); this.r = new JMenuItem(); this.p = new JMenuItem(); this.q = new JMenuItem(); this.t = new JMenuItem(); this.h = new JMenuItem(); this.f = (JMenu)new JMenuItem(); this.i = new JMenuItem(); this.b = new JPopupMenu.Separator(); this.n = new JMenuItem(); this.l = new JMenuItem(); this.m = new JMenuItem(); this.d = new JMenu(); this.j = new JMenuItem(); this.k = new JMenuItem(); this.g = new JMenu(); this.b = (JPopupMenu.Separator)new JMenu(); this.w = new JMenuItem(); this.b = (JPopupMenu.Separator)new JMenuItem(); this.e = (JMenu)new JMenuItem(); this.v = new JMenuItem(); this.f = (JMenu)new c(); this.d.setText("jMenuItem2"); setDefaultCloseOperation(0); setTitle("Effecti - Disputar"); setIconImage((new ImageIcon(getClass().getResource("/img/icone.jpg"))).getImage()); setMinimumSize(new Dimension(1266, 730)); setPreferredSize(new Dimension(1266, 730)); setResizable(false); setSize(new Dimension(0, 0)); addWindowListener(new WindowAdapter(this) { public void windowClosing(WindowEvent param1WindowEvent) { n.a(this.c, param1WindowEvent); } }
/*      */       ); this.c.setAutoscrolls(true); this.c.setOpaque(true); this.bj.setForeground(y.c()); this.bk.setForeground(y.c()); this.bk.setIcon(new ImageIcon(getClass().getResource("/img/bullet_red.png"))); this.bk.setText("Conexão com internet:"); this.bk.setHorizontalTextPosition(2); this.bk.setIconTextGap(7); this.bl.setBackground(new Color(204, 204, 204)); this.bl.setFont(new Font("Tahoma", 1, 11)); this.bl.setForeground(y.c()); this.bl.setText("Carregando ..."); this.bl.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204), 3)); this.bl.setOpaque(true); this.bl.addMouseMotionListener(new MouseMotionAdapter(this) { public void mouseMoved(MouseEvent param1MouseEvent) { n.a(this.c, param1MouseEvent); } }
/*      */       ); this.bl.addMouseListener(new MouseAdapter(this) { public void mouseClicked(MouseEvent param1MouseEvent) { n.b(this.c, param1MouseEvent); } public void mouseExited(MouseEvent param1MouseEvent) { n.c(this.c, param1MouseEvent); } }
/* 1252 */       ); this.bi.setBackground(new Color(204, 204, 204)); this.bi.setFont(new Font("Tahoma", 1, 11)); this.bi.setForeground(y.c()); this.bi.setHorizontalAlignment(0); this.bi.setIcon(new ImageIcon(getClass().getResource("/img/user_comment.png"))); this.bi.setText("Atendimento"); this.bi.setOpaque(true); this.bi.addMouseMotionListener(new MouseMotionAdapter(this) { public void mouseMoved(MouseEvent param1MouseEvent) { n.d(this.c, param1MouseEvent); } }); this.bi.addMouseListener(new MouseAdapter(this) { public void mouseClicked(MouseEvent param1MouseEvent) { n.e(this.c, param1MouseEvent); } public void mouseExited(MouseEvent param1MouseEvent) { n.f(this.c, param1MouseEvent); } }); this.bh.setForeground(y.c()); this.bh.setText("Informative Label"); this.a.setText("Opções"); this.a.setAccelerator(KeyStroke.getKeyStroke(65, 512)); this.a.setIcon(new ImageIcon(getClass().getResource("/img/add.png"))); this.a.setText("Adicionar pregão"); this.a.addActionListener(new ActionListener(this) { public void actionPerformed(ActionEvent param1ActionEvent) { n.a(this.c, param1ActionEvent); } }); this.a.add((JMenuItem)this.a); this.c.setAccelerator(KeyStroke.getKeyStroke(75, 128)); this.c.setIcon(new ImageIcon(getClass().getResource("/img/magnifier.png"))); this.c.setText("Buscar pregão"); this.c.addActionListener(new ActionListener(this) { public void actionPerformed(ActionEvent param1ActionEvent) { n.b(this.c, param1ActionEvent); } }); this.a.add(this.c); this.s.setAccelerator(KeyStroke.getKeyStroke(82, 512)); this.s.setIcon(new ImageIcon(getClass().getResource("/img/delete.png"))); this.s.setText("Remover pregões com disputa encerrada"); this.s.addActionListener(new ActionListener(this) { public void actionPerformed(ActionEvent param1ActionEvent) { n.c(this.c, param1ActionEvent); } }); this.a.add(this.s); this.g.setAccelerator(KeyStroke.getKeyStroke(67, 512)); this.g.setIcon(new ImageIcon(getClass().getResource("/img/config.png"))); this.g.setText("Configurações gerais"); this.g.addActionListener(new ActionListener(this) { public void actionPerformed(ActionEvent param1ActionEvent) { n.d(this.c, param1ActionEvent); } }); this.a.add(this.g); this.a.add(this.a); this.u.setAccelerator(KeyStroke.getKeyStroke(83, 512)); this.u.setIcon(new ImageIcon(getClass().getResource("/img/sair.png"))); this.u.setText("Sair"); this.u.addActionListener(new ActionListener(this) { public void actionPerformed(ActionEvent param1ActionEvent) { n.e(this.c, param1ActionEvent); } }); this.a.add(this.u); this.a.add((JMenu)this.a); this.e.setText("Pregões Ocultos"); this.a.add(this.e); this.c.setText("Ações da disputa"); this.o.setAccelerator(KeyStroke.getKeyStroke(73, 128)); this.o.setIcon(new ImageIcon(getClass().getResource("/img/play.png"))); this.o.setText("Iniciar disputa"); this.o.addActionListener(new ActionListener(this) { public void actionPerformed(ActionEvent param1ActionEvent) { n.f(this.c, param1ActionEvent); } }); this.c.add(this.o); this.r.setAccelerator(KeyStroke.getKeyStroke(80, 128)); this.r.setIcon(new ImageIcon(getClass().getResource("/img/stop.png"))); this.r.setText("Parar disputa"); this.r.addActionListener(new ActionListener(this) { public void actionPerformed(ActionEvent param1ActionEvent) { n.g(this.c, param1ActionEvent); } }); this.c.add(this.r); this.p.setAccelerator(KeyStroke.getKeyStroke(76, 128)); this.p.setIcon(new ImageIcon(getClass().getResource("/img/hammer.png"))); this.p.setText("Lance Manual"); this.p.addActionListener(new ActionListener(this) { public void actionPerformed(ActionEvent param1ActionEvent) { n.h(this.c, param1ActionEvent); } }); this.c.add(this.p); this.q.setAccelerator(KeyStroke.getKeyStroke(79, 128)); this.q.setIcon(new ImageIcon(getClass().getResource("/img/hide.png"))); this.q.setText("Ocultar pregão"); this.q.addActionListener(new ActionListener(this) { public void actionPerformed(ActionEvent param1ActionEvent) { n.i(this.c, param1ActionEvent); } }); this.c.add(this.q); this.t.setAccelerator(KeyStroke.getKeyStroke(82, 128)); this.t.setIcon(new ImageIcon(getClass().getResource("/img/delete.png"))); this.t.setText("Remover pregão"); this.t.addActionListener(new ActionListener(this) { public void actionPerformed(ActionEvent param1ActionEvent) { n.j(this.c, param1ActionEvent); } }); this.c.add(this.t); this.h.setAccelerator(KeyStroke.getKeyStroke(67, 192)); this.h.setIcon(new ImageIcon(getClass().getResource("/img/config.png"))); this.h.setText("Configurações da disputa"); this.h.addActionListener(new ActionListener(this) { public void actionPerformed(ActionEvent param1ActionEvent) { n.k(this.c, param1ActionEvent); } }); this.c.add(this.h); this.f.setAccelerator(KeyStroke.getKeyStroke(72, 128)); this.f.setIcon(new ImageIcon(getClass().getResource("/img/alterar_limite.png"))); this.f.setText("Alterar limite"); this.f.addActionListener(new ActionListener(this) { public void actionPerformed(ActionEvent param1ActionEvent) { n.l(this.c, param1ActionEvent); } }); this.c.add(this.f); this.i.setAccelerator(KeyStroke.getKeyStroke(68, 128)); this.i.setIcon(new ImageIcon(getClass().getResource("/img/information.png"))); this.i.setText("Detalhes"); this.i.addActionListener(new ActionListener(this) { public void actionPerformed(ActionEvent param1ActionEvent) { n.m(this.c, param1ActionEvent); } }); this.c.add(this.i); this.c.add(this.b); this.n.setAccelerator(KeyStroke.getKeyStroke(87, 128)); this.n.setIcon(new ImageIcon(getClass().getResource("/img/excel.png"))); this.n.setText("Importar"); this.n.addActionListener(new ActionListener(this) { public void actionPerformed(ActionEvent param1ActionEvent) { n.n(this.c, param1ActionEvent); } }); this.c.add(this.n); this.l.setAccelerator(KeyStroke.getKeyStroke(69, 128)); this.l.setIcon(new ImageIcon(getClass().getResource("/img/excel.png"))); this.l.setText("Exportar"); this.l.addActionListener(new ActionListener(this) { public void actionPerformed(ActionEvent param1ActionEvent) { n.o(this.c, param1ActionEvent); } }); this.c.add(this.l); this.m.setAccelerator(KeyStroke.getKeyStroke(69, 192)); this.m.setIcon(new ImageIcon(getClass().getResource("/img/excel.png"))); this.m.setText("Exportar Resultado"); this.m.addActionListener(new ActionListener(this) { public void actionPerformed(ActionEvent param1ActionEvent) { n.p(this.c, param1ActionEvent); } }); this.c.add(this.m); this.d.setIcon(new ImageIcon(getClass().getResource("/img/excel.png"))); this.d.setText("Exportar Resultado para CRM"); this.j.setText("Arquivo CSV"); this.j.addActionListener(new ActionListener(this) { public void actionPerformed(ActionEvent param1ActionEvent) { n.q(this.c, param1ActionEvent); } }); this.d.add(this.j); this.k.setText("Arquivo XLSX"); this.k.addActionListener(new ActionListener(this) { public void actionPerformed(ActionEvent param1ActionEvent) { n.r(this.c, param1ActionEvent); } }); this.d.add(this.k); this.c.add(this.d); this.a.add((JMenu)this.c); this.g.setText("Status Effecti"); this.g.addChangeListener(new ChangeListener(this) { public void stateChanged(ChangeEvent param1ChangeEvent) { n.a(this.c, param1ChangeEvent); } }); this.a.add(this.g); this.b.setText("Ajuda"); this.w.setIcon(new ImageIcon(getClass().getResource("/img/date_magnify.png"))); this.w.setText("Histórico de Pagamentos"); this.w.addActionListener(new ActionListener(this) { public void actionPerformed(ActionEvent param1ActionEvent) { n.s(this.c, param1ActionEvent); } }); this.b.add(this.w); this.b.setIcon(new ImageIcon(getClass().getResource("/img/computer.png"))); this.b.setText("Sugestões Computacionais"); this.b.addActionListener(new ActionListener(this) { public void actionPerformed(ActionEvent param1ActionEvent) { n.t(this.c, param1ActionEvent); } }); this.b.add((JMenuItem)this.b); this.e.setIcon(new ImageIcon(getClass().getResource("/img/information.png"))); this.e.setText("Licitações disputáveis"); this.e.addActionListener(new ActionListener(this) { public void actionPerformed(ActionEvent param1ActionEvent) { n.u(this.c, param1ActionEvent); } }); this.b.add(this.e); this.v.setIcon(new ImageIcon(getClass().getResource("/img/information.png"))); this.v.setText("Sobre"); this.v.addActionListener(new ActionListener(this) { public void actionPerformed(ActionEvent param1ActionEvent) { n.v(this.c, param1ActionEvent); } }); this.b.add(this.v); this.a.add((JMenu)this.b); this.f.setText("Notificações      "); this.f.addMouseListener(new MouseAdapter(this) { public void mousePressed(MouseEvent param1MouseEvent) { n.g(this.c, param1MouseEvent); } }); this.a.add(this.f); setJMenuBar((JMenuBar)this.a); GroupLayout groupLayout = new GroupLayout(getContentPane()); getContentPane().setLayout(groupLayout); groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.bl).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.bi, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 724, 32767).addComponent(this.bh).addGap(18, 18, 18).addComponent(this.bk).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.bj).addGap(5, 5, 5)).addComponent(this.c)); groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.bj, -2, 16, -2).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.bi, GroupLayout.Alignment.TRAILING, -2, 20, -2).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.bk, -2, 16, -2).addComponent(this.bl).addComponent(this.bh)))).addGap(0, 0, 0).addComponent(this.c, -1, 687, 32767))); getAccessibleContext().setAccessibleDescription(""); pack(); } private void A(ActionEvent paramActionEvent) { if (paramActionEvent.getModifiers() == 8) j.a().d("alt+a", paramActionEvent.getActionCommand());  a a = new a(); a.setVisible(true); } private void B(ActionEvent paramActionEvent) { if (paramActionEvent.getModifiers() == 8) j.a().d("alt+s", paramActionEvent.getActionCommand());  a.info("Botão sair pressionado"); dJ(); aa(true); } private void dJ() { try (Statement null = a.a().createStatement()) { String str = "UPDATE tbconfiguracaoarremate SET carlembrardadosacesso = FALSE,carusuarioacesso = NULL, carsenhaacesso = NULL;"; statement.execute(str); } catch (Exception exception) { a.warn("Falha ao gravar o lembre-me", exception); }  } private void C(ActionEvent paramActionEvent) { String str = "Este procedimento irá remover os pregões com disputa totalmente encerrada\n\nDeseja realmente realizar a operação?"; int i = JOptionPane.showConfirmDialog(null, str, "Mensagem", 0, 2); if (paramActionEvent.getModifiers() == 8) j.a().d("alt+r", paramActionEvent.getActionCommand());  if (i == 0) dK();  } private void c(WindowEvent paramWindowEvent) { a.bA(); }
/*      */ 
/*      */   
/*      */   private void D(ActionEvent paramActionEvent) {
/* 1256 */     if (paramActionEvent != null && 
/* 1257 */       paramActionEvent.getModifiers() == 8) {
/* 1258 */       j.a().d("alt+c", paramActionEvent.getActionCommand());
/*      */     }
/*      */ 
/*      */     
/* 1262 */     d d = new d();
/* 1263 */     d.setVisible(true);
/*      */   }
/*      */   
/*      */   private void E(ActionEvent paramActionEvent) {
/* 1267 */     if (paramActionEvent.getModifiers() == 2) {
/* 1268 */       j.a().d("ctrl+o", paramActionEvent.getActionCommand());
/*      */     }
/*      */     
/* 1271 */     dL();
/*      */   }
/*      */   
/*      */   private void dL() {
/* 1275 */     b b = c();
/*      */     
/* 1277 */     if (b != null) {
/* 1278 */       b.E();
/*      */     }
/*      */   }
/*      */   
/*      */   private b c() {
/* 1283 */     synchronized (this.g) {
/* 1284 */       Component component = this.c.getSelectedComponent();
/* 1285 */       if (component == null || !(component instanceof b)) {
/* 1286 */         return null;
/*      */       }
/*      */       
/* 1289 */       return (b)component;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void F(ActionEvent paramActionEvent) {
/* 1295 */     if (paramActionEvent.getModifiers() == 2) {
/* 1296 */       j.a().d("ctrl+r", paramActionEvent.getActionCommand());
/*      */     }
/*      */     
/* 1299 */     b b = c();
/*      */     
/* 1301 */     if (b != null) {
/* 1302 */       if (!b.q()) {
/* 1303 */         b.D();
/*      */       } else {
/* 1305 */         String str = String.join("", new CharSequence[] { "A disputa ", b.a().bo(), " do órgão ", 
/* 1306 */               String.valueOf(b.a().K()), " ainda está ativa. É preciso pausar a disputa para removê-la!" });
/*      */         
/* 1308 */         JOptionPane.showMessageDialog(null, str, "Alerta", 2);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   private void G(ActionEvent paramActionEvent) {
/* 1314 */     if (paramActionEvent.getModifiers() == 3) {
/* 1315 */       j.a().d("ctrl+shift+c", paramActionEvent.getActionCommand());
/*      */     }
/*      */     
/* 1318 */     b b = c();
/*      */     
/* 1320 */     if (b != null) {
/* 1321 */       b.p();
/*      */     }
/*      */   }
/*      */   
/*      */   private void H(ActionEvent paramActionEvent) {
/* 1326 */     if (paramActionEvent.getModifiers() == 2) {
/* 1327 */       j.a().d("ctrl+w", paramActionEvent.getActionCommand());
/*      */     }
/*      */     
/* 1330 */     b b = c();
/*      */     
/* 1332 */     if (b != null) {
/* 1333 */       b.G();
/*      */     }
/*      */   }
/*      */   
/*      */   private void I(ActionEvent paramActionEvent) {
/* 1338 */     if (paramActionEvent.getModifiers() == 2) {
/* 1339 */       j.a().d("ctrl+e", paramActionEvent.getActionCommand());
/*      */     }
/*      */     
/* 1342 */     b b = c();
/*      */     
/* 1344 */     if (b != null) {
/* 1345 */       b.F();
/*      */     }
/*      */   }
/*      */   
/*      */   private void J(ActionEvent paramActionEvent) {
/* 1350 */     if (paramActionEvent.getModifiers() == 3) {
/* 1351 */       j.a().d("ctrl+shift+e", paramActionEvent.getActionCommand());
/*      */     }
/*      */     
/* 1354 */     b b = c();
/*      */     
/* 1356 */     if (b != null) {
/* 1357 */       b.s();
/*      */     }
/*      */   }
/*      */   
/*      */   private void K(ActionEvent paramActionEvent) {
/* 1362 */     if (paramActionEvent.getModifiers() == 2) {
/* 1363 */       j.a().d("ctrl+i", paramActionEvent.getActionCommand());
/*      */     }
/*      */     
/* 1366 */     b b = c();
/*      */     
/* 1368 */     if (b != null) {
/* 1369 */       b.o();
/*      */     }
/*      */   }
/*      */   
/*      */   private void L(ActionEvent paramActionEvent) {
/* 1374 */     if (paramActionEvent.getModifiers() == 2) {
/* 1375 */       j.a().d("ctrl+p", paramActionEvent.getActionCommand());
/*      */     }
/*      */     
/* 1378 */     b b = c();
/*      */     
/* 1380 */     if (b != null) {
/* 1381 */       b.c(true);
/*      */     }
/*      */   }
/*      */   
/*      */   private void M(ActionEvent paramActionEvent) {
/* 1386 */     b b = c();
/*      */     
/* 1388 */     if (b != null) {
/* 1389 */       if (paramActionEvent.getModifiers() == 2) {
/* 1390 */         j.a().d("ctrl+l", paramActionEvent.getActionCommand());
/*      */       }
/*      */       
/* 1393 */       b.w();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void N(ActionEvent paramActionEvent) {
/* 1398 */     if (paramActionEvent.getModifiers() == 2) {
/* 1399 */       j.a().d("ctrl+d", paramActionEvent.getActionCommand());
/*      */     }
/*      */     
/* 1402 */     b b = c();
/*      */     
/* 1404 */     if (b != null) {
/* 1405 */       b.q();
/*      */     }
/*      */   }
/*      */   
/*      */   private void j(MouseEvent paramMouseEvent) {
/* 1410 */     setCursor(new Cursor(12));
/* 1411 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 1412 */     hashMap.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
/* 1413 */     Font font = this.bl.getFont().deriveFont((Map)hashMap);
/* 1414 */     this.bl.setFont(font);
/*      */   }
/*      */   
/*      */   private void k(MouseEvent paramMouseEvent) {
/* 1418 */     setCursor(new Cursor(0));
/* 1419 */     Font font = new Font(this.bl.getFont().getName(), 1, this.bl.getFont().getSize());
/* 1420 */     this.bl.setFont(font);
/*      */   }
/*      */   
/*      */   private void l(MouseEvent paramMouseEvent) {
/* 1424 */     if (this.b != null) {
/* 1425 */       this.b.run();
/*      */     }
/*      */   }
/*      */   
/*      */   private void O(ActionEvent paramActionEvent) {
/* 1430 */     if (this.b != null) {
/* 1431 */       this.b.run();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void P(ActionEvent paramActionEvent) {
/*      */     try {
/* 1438 */       j j = new j();
/* 1439 */       i i = new i(j, true);
/* 1440 */       i.setVisible(true);
/* 1441 */     } catch (Exception exception) {
/* 1442 */       a.warn("Erro ao verificar as configurações mínimas computacionais", exception);
/* 1443 */       JOptionPane.showMessageDialog(null, "Erro ao verificar as configurações mínimas computacionais", "Erro", 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void Q(ActionEvent paramActionEvent) {
/*      */     try {
/* 1450 */       if (paramActionEvent.getModifiers() == 2) {
/* 1451 */         j.a().d("ctrl+k", paramActionEvent.getActionCommand());
/*      */       }
/*      */       
/* 1454 */       c c = new c();
/* 1455 */       c.setVisible(true);
/* 1456 */     } catch (SQLException sQLException) {
/* 1457 */       a.warn("Erro ao buscar pregões", sQLException);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void R(ActionEvent paramActionEvent) {
/*      */     try {
/* 1463 */       j.a().cv();
/*      */       
/* 1465 */       j j = new j();
/* 1466 */       j.setVisible(true);
/* 1467 */     } catch (Exception exception) {
/* 1468 */       a.warn("Erro ao apresentar tela Sobre", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void S(ActionEvent paramActionEvent) {
/* 1478 */     if (paramActionEvent.getModifiers() == 2) {
/* 1479 */       j.a().d("ctrl+h", paramActionEvent.getActionCommand());
/*      */     }
/*      */     
/* 1482 */     b b = new b();
/* 1483 */     b.setVisible(true);
/* 1484 */     double d = b.l();
/*      */     
/* 1486 */     if (d >= 0.0D) {
/* 1487 */       b b1 = c();
/* 1488 */       int[] arrayOfInt = b1.a().getSelectedRows();
/* 1489 */       h h = b1.a();
/* 1490 */       i i = b1.a();
/*      */       
/* 1492 */       for (int j : arrayOfInt) {
/* 1493 */         int k = h.convertRowIndexToModel(j);
/* 1494 */         i.setValueAt(Double.valueOf(d), k, 10);
/*      */       } 
/*      */       
/* 1497 */       j.a().n(b1.a());
/*      */     } 
/*      */   }
/*      */   
/*      */   private void e(ChangeEvent paramChangeEvent) {
/* 1502 */     if (this.g.isSelected()) {
/* 1503 */       byte b = 0;
/* 1504 */       ArrayList<String> arrayList = new ArrayList();
/*      */       
/* 1506 */       while (b < this.g.getItemCount()) {
/* 1507 */         JMenuItem jMenuItem = this.g.getItem(b);
/* 1508 */         arrayList.add(jMenuItem.getText());
/* 1509 */         b++;
/*      */       } 
/*      */       
/* 1512 */       j.a().l(arrayList);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void m(MouseEvent paramMouseEvent) {
/* 1517 */     setCursor(new Cursor(12));
/* 1518 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 1519 */     hashMap.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
/* 1520 */     Font font = this.bi.getFont().deriveFont((Map)hashMap);
/* 1521 */     this.bi.setFont(font);
/*      */   }
/*      */   
/*      */   private void n(MouseEvent paramMouseEvent) {
/* 1525 */     setCursor(new Cursor(0));
/* 1526 */     Font font = new Font(this.bi.getFont().getName(), 1, this.bi.getFont().getSize());
/* 1527 */     this.bi.setFont(font);
/*      */   }
/*      */   
/*      */   private void o(MouseEvent paramMouseEvent) {
/* 1531 */     dF();
/*      */   }
/*      */   
/*      */   private void p(MouseEvent paramMouseEvent) {
/* 1535 */     ArrayList<String> arrayList = new ArrayList();
/* 1536 */     for (byte b = 0; b < this.f.getItemCount(); b++) {
/* 1537 */       JMenuItem jMenuItem = this.f.getItem(b);
/* 1538 */       arrayList.add(jMenuItem.getText());
/*      */     } 
/* 1540 */     j.a().m(arrayList);
/*      */   }
/*      */   
/*      */   private void T(ActionEvent paramActionEvent) {
/* 1544 */     y.l(z.a.getUrl());
/*      */   }
/*      */   
/*      */   private void U(ActionEvent paramActionEvent) {
/* 1548 */     b b = c();
/*      */     
/* 1550 */     if (b != null) {
/* 1551 */       b.g(".csv");
/*      */     }
/*      */   }
/*      */   
/*      */   private void V(ActionEvent paramActionEvent) {
/* 1556 */     b b = c();
/*      */     
/* 1558 */     if (b != null) {
/* 1559 */       b.g(".xlsx");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(Long paramLong, o paramo, List<Integer> paramList) {
/* 1571 */     if (paramList.isEmpty()) {
/*      */       return;
/*      */     }
/*      */     
/* 1575 */     HashSet<b> hashSet = new HashSet();
/* 1576 */     for (Integer integer : paramList) {
/* 1577 */       b b = a(integer.intValue(), paramo, paramLong.longValue());
/* 1578 */       if (b != null) {
/* 1579 */         hashSet.add(b);
/*      */       }
/*      */     } 
/*      */     
/* 1583 */     synchronized (this.g) {
/* 1584 */       hashSet.forEach(paramb -> {
/*      */             try {
/*      */               this.c.remove((Component)paramb);
/* 1587 */             } catch (Exception exception) {
/*      */               j j = paramb.a();
/*      */               a.warn("Cnpj {}, Número {}, Uasg - Failed to remove bidding tab", new Object[] { Long.valueOf(j.C()), j.bo(), Integer.valueOf(j.K()) });
/*      */             } 
/*      */           });
/*      */     } 
/*      */   }
/*      */   
/*      */   public void a(j paramj, Color paramColor) {
/* 1596 */     synchronized (this.g) {
/* 1597 */       int i = a(paramj);
/* 1598 */       if (i >= 0) {
/* 1599 */         this.c.setForegroundAt(i, paramColor);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void t(j paramj) {
/* 1605 */     synchronized (this.g) {
/* 1606 */       int i = a(paramj);
/* 1607 */       this.c.setSelectedIndex(i);
/*      */     } 
/*      */   }
/*      */   
/*      */   private int a(j paramj) {
/* 1612 */     for (byte b = 0; b < this.c.getTabCount(); b++) {
/* 1613 */       Component component = this.c.getComponentAt(b);
/* 1614 */       if (component instanceof b) {
/* 1615 */         j j1 = ((b)component).a();
/* 1616 */         int i = j1.v();
/* 1617 */         long l = j1.C();
/* 1618 */         o o = j1.b().a();
/*      */         
/* 1620 */         if (i == paramj.v() && l == paramj.C() && o == paramj.b().a()) {
/* 1621 */           return b;
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1626 */     return -1;
/*      */   }
/*      */   
/*      */   public b a(int paramInt, o paramo, long paramLong) {
/* 1630 */     synchronized (this.g) {
/* 1631 */       for (byte b = 0; b < this.c.getTabCount(); b++) {
/* 1632 */         Component component = this.c.getComponentAt(b);
/* 1633 */         if (component instanceof b) {
/* 1634 */           b b1 = (b)component;
/* 1635 */           j j = b1.a();
/*      */           
/* 1637 */           boolean bool = (paramo == j.b().a()) ? true : false;
/* 1638 */           if (!bool && j.b().a() == o.c && paramo == o.b) {
/* 1639 */             bool = true;
/*      */           }
/*      */           
/* 1642 */           if (paramInt == j.v() && bool && paramLong == j.a().x()) {
/* 1643 */             return b1;
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/* 1648 */       return null;
/*      */     } 
/*      */   }
/*      */   
/*      */   public void b(b paramb) {
/* 1653 */     synchronized (this.g) {
/* 1654 */       this.c.setSelectedComponent((Component)paramb);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void dM() {
/* 1662 */     aa(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void aa(boolean paramBoolean) {
/* 1671 */     synchronized (this.g) {
/* 1672 */       boolean bool = true;
/* 1673 */       int i = this.c.getTabCount();
/*      */       
/* 1675 */       for (byte b = 0; b < i; b++) {
/* 1676 */         if (this.c.getComponentAt(b) instanceof b) {
/* 1677 */           b b1 = (b)this.c.getComponentAt(b);
/*      */ 
/*      */           
/* 1680 */           if (b1.q()) {
/* 1681 */             a.info("Ainda existem disputas em andamento");
/* 1682 */             bool = false;
/* 1683 */             this.c.setSelectedComponent((Component)b1);
/* 1684 */             JOptionPane.showMessageDialog(null, "Você precisa parar todas as disputas ativas antes de encerrar o Disputar", "Alerta", 2);
/*      */ 
/*      */             
/*      */             break;
/*      */           } 
/*      */ 
/*      */           
/* 1691 */           if (b1.p()) {
/* 1692 */             b1.t();
/*      */           }
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 1698 */       if (bool) {
/* 1699 */         if (!paramBoolean) {
/* 1700 */           System.exit(0);
/* 1701 */           a.info("Finaliza o sistema");
/*      */         } else {
/* 1703 */           dispose();
/* 1704 */           this.c.removeAll();
/* 1705 */           m m = new m();
/* 1706 */           m.setVisible(true);
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void dN() {
/* 1713 */     if (c.a().f()) {
/* 1714 */       this.bi.setVisible(false);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void dO() {
/* 1722 */     char c1 = 'Ϩ';
/* 1723 */     char c2 = 'Ϩ';
/*      */     
/* 1725 */     Timer timer = new Timer();
/* 1726 */     timer.schedule(new TimerTask(this) {
/* 1727 */           private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
/*      */           
/*      */           private int dc;
/*      */           
/*      */           public void run() {
/* 1732 */             if (n.b(this.c).getText().isEmpty() || this.dc == 30) {
/* 1733 */               long l = System.currentTimeMillis();
/* 1734 */               n.a(this.c).setTime(y.i().getTime());
/* 1735 */               l = System.currentTimeMillis() - l;
/*      */ 
/*      */ 
/*      */               
/* 1739 */               if (l >= 1000L) {
/* 1740 */                 int i = (int)l;
/* 1741 */                 n.a(this.c).add(14, i);
/*      */               } 
/*      */               
/* 1744 */               this.dc = 0;
/*      */             } else {
/* 1746 */               this.dc++;
/* 1747 */               n.a(this.c).add(13, 1);
/*      */             } 
/*      */             
/* 1750 */             if (n.a(this.c) != null) {
/* 1751 */               n.b(this.c).setText("Horário de Brasília: " + this.dateFormat.format(n.a(this.c).getTime()));
/*      */             }
/*      */           }
/*      */         }c1, c2);
/*      */   }
/*      */   
/*      */   private void dP() {
/* 1758 */     char c1 = 'ᎈ';
/* 1759 */     char c2 = 'ᎈ';
/*      */     
/* 1761 */     dQ();
/*      */     
/* 1763 */     Timer timer = new Timer();
/* 1764 */     timer.schedule(new TimerTask(this)
/*      */         {
/*      */           public void run() {
/* 1767 */             n.a(this.c);
/*      */           }
/*      */         },  c1, c2);
/*      */   }
/*      */   
/*      */   private void dQ() {
/* 1773 */     File file = new File(this.bk.getIcon().toString());
/*      */     
/* 1775 */     if (A.a().bX()) {
/* 1776 */       if ("/img/bullet_red.png".contains(file.getName())) {
/* 1777 */         this.bk.setIcon(new ImageIcon(getClass().getResource("/img/bullet_green.png")));
/*      */       }
/* 1779 */     } else if ("/img/bullet_green.png".contains(file.getName())) {
/* 1780 */       this.bk.setIcon(new ImageIcon(getClass().getResource("/img/bullet_red.png")));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private synchronized void dR() {
/* 1788 */     this.bl.setText("Carregando ...");
/*      */     
/* 1790 */     i i = g.a().f();
/* 1791 */     if (i != null && i.has("text")) {
/* 1792 */       this.b = null;
/*      */       
/* 1794 */       if (!i.isNull("action")) {
/* 1795 */         String str1 = i.getString("action");
/*      */ 
/*      */         
/* 1798 */         this.b = (JPopupMenu.Separator)(() -> {
/*      */             y.l(paramString);
/*      */             
/*      */             j.a().aF(this.w.getText());
/*      */           });
/*      */         
/* 1804 */         this.bl.setToolTipText("Clique aqui para visualizar");
/*      */ 
/*      */         
/* 1807 */         this.w.setEnabled(true);
/*      */       } else {
/*      */         
/* 1810 */         this.w.setEnabled(false);
/*      */       } 
/*      */       
/* 1813 */       String str = i.getString("text");
/*      */       
/* 1815 */       if (str.contains("span")) {
/* 1816 */         Document document = Jsoup.parse(str);
/* 1817 */         Element element = document.select("span").first();
/* 1818 */         str = element.text();
/*      */         
/* 1820 */         a a = new a(element.attr("style"));
/* 1821 */         String str1 = a.getValue("color").replace("#", "");
/* 1822 */         str1 = String.join("", new CharSequence[] { "#", StringUtils.stripStart(str1, "0") });
/* 1823 */         this.bl.setForeground(Color.decode(str1));
/*      */       } 
/* 1825 */       this.bl.setText(str);
/*      */ 
/*      */       
/* 1828 */       if (!i.isNull("css")) {
/* 1829 */         String str1 = i.getString("css");
/* 1830 */         a a = new a(str1);
/* 1831 */         String str2 = a.getValue("background").replace("#", "");
/* 1832 */         str2 = String.join("", new CharSequence[] { "#", StringUtils.stripStart(str2, "0") });
/* 1833 */         this.bl.setBackground(Color.decode(str2));
/*      */         
/* 1835 */         str2 = a.getValue("border-color").replace("#", "");
/* 1836 */         str2 = String.join("", new CharSequence[] { "#", StringUtils.stripStart(str2, "0") });
/* 1837 */         this.bl.setBorder(BorderFactory.createLineBorder(Color.decode(str2), 3));
/*      */       } 
/*      */     } else {
/*      */       
/* 1841 */       this.bl.setToolTipText("Clique aqui para recarregar");
/*      */ 
/*      */       
/* 1844 */       this.b = (JPopupMenu.Separator)(() -> dS());
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1849 */       this.bl.setText("Recarregar");
/*      */       
/* 1851 */       this.w.setEnabled(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void dS() {
/* 1859 */     (new Thread(() -> dR()))
/*      */       
/* 1861 */       .start();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void dT() {
/* 1870 */     if (this.e != null) {
/*      */       return;
/*      */     }
/*      */     
/* 1874 */     this.e = (JMenu)Executors.newSingleThreadScheduledExecutor();
/* 1875 */     this.e.scheduleAtFixedRate(b(), 0L, 60L, TimeUnit.MINUTES);
/*      */   }
/*      */   
/*      */   private Runnable b() {
/* 1879 */     return new Runnable(this)
/*      */       {
/*      */         public void run() {
/* 1882 */           n.a(this.c).removeAll();
/* 1883 */           i i = i.a().g();
/* 1884 */           String str = "";
/*      */           
/* 1886 */           if (i != null) {
/* 1887 */             str = i.getString("lowest_human_status");
/*      */             
/* 1889 */             f f = i.c("enabled_components");
/* 1890 */             for (byte b = 0; b < f.length(); b++) {
/* 1891 */               i i1 = f.b(b);
/*      */               
/* 1893 */               int j = i1.getInt("status");
/* 1894 */               if (j != 1) {
/*      */ 
/*      */ 
/*      */                 
/* 1898 */                 int k = i1.getInt("id");
/*      */                 
/* 1900 */                 String str1 = i1.getString("status_name");
/* 1901 */                 Color color = a(str1);
/*      */                 
/* 1903 */                 f f1 = i.a().a(k, 1);
/* 1904 */                 a(f1, color);
/*      */                 
/* 1906 */                 f1 = i.a().a(k, 2);
/* 1907 */                 a(f1, color);
/*      */                 
/* 1909 */                 f1 = i.a().a(k, 3);
/* 1910 */                 a(f1, color);
/*      */               } 
/*      */             } 
/*      */           } 
/* 1914 */           if (n.a(this.c).getItemCount() == 0) {
/* 1915 */             n.a(this.c).add(new JMenuItem("Não há incidentes"));
/*      */           }
/* 1917 */           n.a(this.c).setForeground(a(str));
/*      */         }
/*      */         
/*      */         private void a(f param1f, Color param1Color) {
/* 1921 */           if (param1f != null && param1f.length() > 0) {
/* 1922 */             for (byte b = 0; b < param1f.length(); b++) {
/* 1923 */               i i = param1f.b(b);
/*      */               
/* 1925 */               String str1 = i.getString("name");
/* 1926 */               String str2 = String.join("", new CharSequence[] { str1, " (Clique aqui para mais informações)" });
/*      */               
/* 1928 */               int j = i.getInt("id");
/* 1929 */               String str3 = i.getString("permalink");
/*      */               
/* 1931 */               JMenuItem jMenuItem = new JMenuItem(str2);
/* 1932 */               jMenuItem.addActionListener(param1ActionEvent -> j.a().a(y.l(param1String1), param1Int, param1String2));
/*      */ 
/*      */               
/* 1935 */               jMenuItem.setForeground(param1Color);
/*      */               
/* 1937 */               n.a(this.c).add(jMenuItem, 0);
/*      */             } 
/*      */           }
/*      */         }
/*      */         
/*      */         private Color a(String param1String) {
/* 1943 */           Color color = y.e();
/*      */           
/* 1945 */           if (param1String != null && !param1String.isEmpty()) {
/* 1946 */             switch (param1String) {
/*      */               case "Problemas de performance":
/* 1948 */                 color = y.d();
/*      */                 break;
/*      */               case "Indisponibilidade parcial":
/* 1951 */                 color = y.g();
/*      */                 break;
/*      */               case "Indisponibilidade total":
/* 1954 */                 color = y.f();
/*      */                 break;
/*      */             } 
/*      */ 
/*      */ 
/*      */           
/*      */           }
/* 1961 */           return color;
/*      */         }
/*      */       };
/*      */   }
/*      */   
/*      */   private void dU() {
/* 1967 */     long l = TimeUnit.MINUTES.toMillis(10L);
/* 1968 */     Timer timer = new Timer();
/* 1969 */     timer.schedule(new TimerTask(this)
/*      */         {
/*      */           public void run() {
/*      */             try {
/* 1973 */               f.a().cs();
/* 1974 */             } catch (Exception exception) {
/* 1975 */               n.e().warn("Failed to send log in JFPrincipal");
/*      */             } 
/*      */           }
/*      */         },  0L, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void dV() {
/* 1985 */     (new Thread(() -> {
/*      */           try {
/*      */             try(Statement null = a.a().createStatement(); ResultSet null = statement.executeQuery("SELECT carnaomostarinformacoeshardware FROM tbconfiguracaoarremate")) {
/*      */               if (resultSet.next() && resultSet.getBoolean(1)) {
/*      */                 return;
/*      */               }
/*      */             } 
/*      */             
/*      */             j j = new j();
/*      */             
/*      */             boolean bool = j.bC();
/*      */             
/*      */             if (!bool) {
/*      */               return;
/*      */             }
/*      */             
/*      */             j.a().a(j, false);
/*      */             
/*      */             if (!j.bN()) {
/*      */               i i = new i(j);
/*      */               i.setVisible(true);
/*      */             } 
/* 2007 */           } catch (Exception exception) {
/*      */             a.warn("Erro ao verificar as configurações mínimas computacionais", exception);
/*      */           } 
/* 2010 */         })).start();
/*      */   }
/*      */   
/*      */   private void dW() {
/* 2014 */     (new Timer()).schedule(new TimerTask(this) {
/*      */           private Map<Integer, Boolean> r() {
/* 2016 */             HashMap<Object, Object> hashMap = new HashMap<>();
/*      */             
/* 2018 */             try(Statement null = a.a().createStatement(); ResultSet null = statement.executeQuery("SELECT notcodigo, notvisualizado FROM tbnotificacoes")) {
/*      */               
/* 2020 */               while (resultSet.next()) {
/* 2021 */                 hashMap.put(Integer.valueOf(resultSet.getInt("notcodigo")), Boolean.valueOf(resultSet.getBoolean("notvisualizado")));
/*      */               }
/* 2023 */             } catch (SQLException sQLException) {
/* 2024 */               n.e().warn("Erro ao carregar notificações da base", sQLException);
/*      */             } 
/*      */             
/* 2027 */             return (Map)hashMap;
/*      */           }
/*      */           
/*      */           private void as(int param1Int) {
/* 2031 */             String str = "INSERT INTO tbnotificacoes(notcodigo) VALUES (?)";
/* 2032 */             try (CallableStatement null = a.a().prepareCall(str)) {
/* 2033 */               callableStatement.setInt(1, param1Int);
/* 2034 */               callableStatement.execute();
/* 2035 */             } catch (SQLException sQLException) {
/* 2036 */               n.e().warn("Erro ao inserir notificação", sQLException);
/*      */             } 
/*      */           }
/*      */           
/*      */           private void at(int param1Int) {
/* 2041 */             String str = "UPDATE tbnotificacoes SET notvisualizado = ? WHERE notcodigo = ?";
/* 2042 */             try (CallableStatement null = a.a().prepareCall(str)) {
/* 2043 */               callableStatement.setBoolean(1, true);
/* 2044 */               callableStatement.setInt(2, param1Int);
/* 2045 */               callableStatement.executeUpdate();
/* 2046 */             } catch (SQLException sQLException) {
/* 2047 */               n.e().warn("Erro ao atualizar notificação", sQLException);
/*      */             } 
/*      */           }
/*      */           
/*      */           private boolean o(i param1i) {
/* 2052 */             if (!param1i.isNull("version") && !param1i.getString("version").isEmpty()) {
/*      */               try {
/* 2054 */                 String[] arrayOfString1 = param1i.getString("version").split("\\.");
/* 2055 */                 int j = Integer.parseInt(arrayOfString1[0]);
/* 2056 */                 int k = Integer.parseInt(arrayOfString1[1]);
/* 2057 */                 int m = Integer.parseInt(arrayOfString1[2]);
/*      */                 
/* 2059 */                 String[] arrayOfString2 = "2.97.0".split("\\.");
/* 2060 */                 int i1 = Integer.parseInt(arrayOfString2[0]);
/* 2061 */                 int i2 = Integer.parseInt(arrayOfString2[1]);
/* 2062 */                 int i3 = Integer.parseInt(arrayOfString2[2]);
/*      */                 
/* 2064 */                 return (i1 < j || (i2 < k && i1 == j) || (i3 < m && i2 == k && i1 == j));
/*      */               
/*      */               }
/* 2067 */               catch (Exception exception) {
/* 2068 */                 n.e().warn("Erro ao validar versão na notificação", exception);
/*      */               } 
/*      */             }
/*      */             
/* 2072 */             return false;
/*      */           }
/*      */ 
/*      */           
/*      */           public void run() {
/*      */             try {
/* 2078 */               if (n.b(this.c).getItemCount() > 0) {
/* 2079 */                 n.b(this.c).removeAll();
/*      */               }
/*      */               
/* 2082 */               i i = g.a().e();
/* 2083 */               if (i != null) {
/* 2084 */                 c c = (c)n.b(this.c);
/* 2085 */                 Map<Integer, Boolean> map = r();
/* 2086 */                 ArrayList arrayList = y.a(i.c("data"), "code");
/* 2087 */                 byte b = 0;
/*      */                 
/* 2089 */                 for (i i1 : arrayList) {
/* 2090 */                   boolean bool; BufferedImage bufferedImage; String str2; byte[] arrayOfByte; JLabel jLabel; JOptionPane jOptionPane; JDialog jDialog; String str3; if (o(i1)) {
/*      */                     continue;
/*      */                   }
/*      */                   
/* 2094 */                   int j = i1.getInt("type");
/* 2095 */                   br.com.arremate.f.n n1 = br.com.arremate.f.n.a(j);
/* 2096 */                   int k = i1.getInt("code");
/*      */ 
/*      */ 
/*      */                   
/* 2100 */                   if (!map.containsKey(Integer.valueOf(k))) {
/* 2101 */                     as(k);
/* 2102 */                     bool = true;
/*      */                   } else {
/* 2104 */                     bool = !((Boolean)map.get(Integer.valueOf(k))).booleanValue() ? true : false;
/*      */                   } 
/*      */                   
/* 2107 */                   if (n1 == br.com.arremate.f.n.c) {
/* 2108 */                     if (!bool) {
/*      */                       continue;
/*      */                     }
/*      */ 
/*      */                     
/* 2113 */                     JOptionPane.showMessageDialog(
/* 2114 */                         n.a(), i1
/* 2115 */                         .getString("event"), "Comunicado", 1);
/*      */ 
/*      */                     
/* 2118 */                     at(k);
/*      */                     
/*      */                     continue;
/*      */                   } 
/* 2122 */                   String str1 = String.join("", new CharSequence[] { i1.getString("message"), " (Clique aqui para mais informações)" });
/* 2123 */                   JMenuItem jMenuItem = new JMenuItem(str1);
/*      */                   
/* 2125 */                   if (bool) {
/* 2126 */                     b++;
/* 2127 */                     Color color = y.d();
/* 2128 */                     jMenuItem.setForeground(color);
/* 2129 */                     jMenuItem.addActionListener(param1ActionEvent -> {
/*      */                           if (param1JMenuItem.getForeground().equals(param1Color)) {
/*      */                             param1JMenuItem.setForeground(Color.BLACK);
/*      */                             
/*      */                             param1c.decrement();
/*      */                             at(param1Int);
/*      */                           } 
/*      */                         });
/*      */                   } 
/* 2138 */                   switch (n.null.o[n1.ordinal()]) {
/*      */ 
/*      */                     
/*      */                     case 1:
/* 2142 */                       str2 = i1.getString("event");
/* 2143 */                       arrayOfByte = Base64.decodeBase64(str2);
/* 2144 */                       try (ByteArrayInputStream null = new ByteArrayInputStream(arrayOfByte)) {
/* 2145 */                         bufferedImage = ImageIO.read(byteArrayInputStream);
/*      */                       } 
/*      */ 
/*      */                       
/* 2149 */                       jLabel = new JLabel();
/* 2150 */                       jLabel.setIcon(new ImageIcon(bufferedImage));
/* 2151 */                       jLabel.setHorizontalAlignment(0);
/* 2152 */                       jLabel.setVerticalTextPosition(0);
/* 2153 */                       jLabel.setHorizontalTextPosition(0);
/*      */ 
/*      */                       
/* 2156 */                       jOptionPane = new JOptionPane(jLabel, -1, -1);
/* 2157 */                       jDialog = jOptionPane.createDialog("Comunicado");
/* 2158 */                       jDialog.setIconImage((new ImageIcon(getClass().getResource("/img/information.png"))).getImage());
/*      */ 
/*      */                       
/* 2161 */                       jMenuItem.addActionListener(param1ActionEvent -> param1JDialog.setVisible(true));
/*      */                       break;
/*      */ 
/*      */ 
/*      */                     
/*      */                     case 2:
/* 2167 */                       str3 = i1.getString("event");
/* 2168 */                       jMenuItem.addActionListener(param1ActionEvent -> y.l(param1String));
/*      */                       break;
/*      */                   } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 2176 */                   jMenuItem.addActionListener(param1ActionEvent -> j.a().a(param1Int1, param1Int2, param1JMenuItem.getText()));
/*      */ 
/*      */                   
/* 2179 */                   c.add(jMenuItem, 0);
/*      */                 } 
/*      */                 
/* 2182 */                 c.c(b);
/*      */               } 
/* 2184 */             } catch (RuntimeException|java.io.IOException runtimeException) {
/* 2185 */               n.e().warn("Erro ao carregar notificação", runtimeException);
/*      */             } 
/*      */           }
/* 2188 */         }TimeUnit.SECONDS.toMillis(2L), TimeUnit.HOURS.toMillis(1L));
/*      */   }
/*      */   
/*      */   private void dX() {
/* 2192 */     Timer timer = new Timer();
/* 2193 */     long l = TimeUnit.MINUTES.toMillis(5L);
/*      */     
/* 2195 */     timer.schedule(new TimerTask(this)
/*      */         {
/*      */           public void run() {
/* 2198 */             j.a().cw();
/*      */           }
/*      */         },  l, l);
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
/*      */   public static Calendar i() {
/* 2217 */     return (Calendar)(a()).g;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JMenu a() {
/* 2226 */     return this.e;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Long a() {
/* 2235 */     return Long.valueOf((a()).g.getTimeInMillis());
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\n\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */