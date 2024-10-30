/*     */ package br.com.arremate.n;
/*     */ import java.awt.Insets;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.nio.file.Files;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JPasswordField;
/*     */ import javax.swing.KeyStroke;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.filechooser.FileNameExtensionFilter;
/*     */ 
/*     */ public class e extends JDialog {
/*     */   private final d c;
/*     */   private File b;
/*     */   private JButton m;
/*     */   private JButton n;
/*     */   private JLabel Y;
/*     */   
/*     */   public e(d paramd) {
/*  29 */     super(paramd, "Certificado Digital ComprasNet");
/*  30 */     k();
/*  31 */     l();
/*     */     
/*  33 */     this.c = paramd;
/*     */     
/*  35 */     setLocationRelativeTo(null);
/*     */   }
/*     */   private JLabel af; private JLabel ag; private JLabel ah; private JPanel o; private JPasswordField b;
/*     */   private void l() {
/*  39 */     KeyStroke keyStroke = KeyStroke.getKeyStroke(27, 0);
/*  40 */     byte b = 2;
/*  41 */     getRootPane().registerKeyboardAction(paramActionEvent -> dispose(), keyStroke, b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void k() {
/*  52 */     this.o = new JPanel();
/*  53 */     this.Y = new JLabel();
/*  54 */     this.af = new JLabel();
/*  55 */     this.n = new JButton();
/*  56 */     this.ag = new JLabel();
/*  57 */     this.ah = new JLabel();
/*  58 */     this.b = new JPasswordField();
/*  59 */     this.m = new JButton();
/*     */     
/*  61 */     setDefaultCloseOperation(2);
/*  62 */     setTitle("Effecti - Disputar");
/*     */     
/*  64 */     this.Y.setText("Adicione aqui os cerificado(s) da(s) empresa(s) no portal ComprasNet");
/*     */     
/*  66 */     this.af.setText("Certificado:");
/*     */     
/*  68 */     this.n.setIcon(new ImageIcon(getClass().getResource("/img/select_file.png")));
/*  69 */     this.n.setText("Selecionar Certificado");
/*  70 */     this.n.addActionListener(new ActionListener(this) {
/*     */           public void actionPerformed(ActionEvent param1ActionEvent) {
/*  72 */             e.a(this.a, param1ActionEvent);
/*     */           }
/*     */         });
/*     */     
/*  76 */     this.ag.setText("Certificado não selecionado");
/*     */     
/*  78 */     this.ah.setText("Senha:");
/*     */     
/*  80 */     this.b.addKeyListener(new KeyAdapter(this) {
/*     */           public void keyPressed(KeyEvent param1KeyEvent) {
/*  82 */             e.a(this.a, param1KeyEvent);
/*     */           }
/*     */         });
/*     */     
/*  86 */     this.m.setIcon(new ImageIcon(getClass().getResource("/img/add.png")));
/*  87 */     this.m.setText("Importar Certificado");
/*  88 */     this.m.setMargin(new Insets(2, 10, 2, 10));
/*  89 */     this.m.addActionListener(new ActionListener(this) {
/*     */           public void actionPerformed(ActionEvent param1ActionEvent) {
/*  91 */             e.b(this.a, param1ActionEvent);
/*     */           }
/*     */         });
/*     */     
/*  95 */     GroupLayout groupLayout1 = new GroupLayout(this.o);
/*  96 */     this.o.setLayout(groupLayout1);
/*  97 */     groupLayout1.setHorizontalGroup(groupLayout1
/*  98 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  99 */         .addGroup(groupLayout1.createSequentialGroup()
/* 100 */           .addContainerGap()
/* 101 */           .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 102 */             .addGroup(groupLayout1.createSequentialGroup()
/* 103 */               .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 104 */                 .addComponent(this.b, GroupLayout.Alignment.LEADING, -2, 180, -2)
/* 105 */                 .addComponent(this.n, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 106 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 107 */               .addComponent(this.ag, -2, 300, -2))
/* 108 */             .addComponent(this.Y)
/* 109 */             .addComponent(this.af)
/* 110 */             .addComponent(this.ah))
/* 111 */           .addContainerGap(-1, 32767))
/* 112 */         .addGroup(GroupLayout.Alignment.TRAILING, groupLayout1.createSequentialGroup()
/* 113 */           .addContainerGap(-1, 32767)
/* 114 */           .addComponent(this.m, -2, 160, -2)
/* 115 */           .addContainerGap()));
/*     */     
/* 117 */     groupLayout1.setVerticalGroup(groupLayout1
/* 118 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 119 */         .addGroup(groupLayout1.createSequentialGroup()
/* 120 */           .addContainerGap()
/* 121 */           .addComponent(this.Y)
/* 122 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 123 */           .addComponent(this.af)
/* 124 */           .addGap(1, 1, 1)
/* 125 */           .addGroup(groupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 126 */             .addComponent(this.n)
/* 127 */             .addComponent(this.ag))
/* 128 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 129 */           .addComponent(this.ah)
/* 130 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 131 */           .addComponent(this.b, -2, 20, -2)
/* 132 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, 32767)
/* 133 */           .addComponent(this.m)
/* 134 */           .addContainerGap()));
/*     */ 
/*     */     
/* 137 */     GroupLayout groupLayout2 = new GroupLayout(getContentPane());
/* 138 */     getContentPane().setLayout(groupLayout2);
/* 139 */     groupLayout2.setHorizontalGroup(groupLayout2
/* 140 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 141 */         .addComponent(this.o, -1, -1, 32767));
/*     */     
/* 143 */     groupLayout2.setVerticalGroup(groupLayout2
/* 144 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 145 */         .addComponent(this.o, -2, -1, -2));
/*     */ 
/*     */     
/* 148 */     pack();
/*     */   }
/*     */ 
/*     */   
/*     */   private void o(ActionEvent paramActionEvent) {
/* 153 */     JFileChooser jFileChooser = new JFileChooser();
/* 154 */     FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("Certificado (.pfx, .p12)", new String[] { "pfx", "p12" });
/* 155 */     jFileChooser.setFileFilter(fileNameExtensionFilter);
/* 156 */     jFileChooser.setAcceptAllFileFilterUsed(false);
/*     */ 
/*     */     
/* 159 */     int i = jFileChooser.showOpenDialog(this);
/*     */ 
/*     */     
/* 162 */     if (i == 0) {
/* 163 */       this.b = (JPasswordField)jFileChooser.getSelectedFile();
/* 164 */       this.ag.setText(this.b.getAbsolutePath());
/* 165 */       this.b.requestFocus();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void d(KeyEvent paramKeyEvent) {
/* 170 */     if (paramKeyEvent.getKeyCode() == 10) {
/* 171 */       p((ActionEvent)null);
/*     */     }
/*     */   }
/*     */   
/*     */   private void p(ActionEvent paramActionEvent) {
/*     */     byte[] arrayOfByte;
/* 177 */     if (this.b == null) {
/* 178 */       JOptionPane.showMessageDialog(this, "Certificado não informado! Por favor selecione um certificado.", "Mensagem", 0);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 184 */     if ((this.b.getPassword()).length <= 0) {
/* 185 */       JOptionPane.showMessageDialog(this, "Senha não informada! Por favor informe uma senha.", "Mensagem", 0);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/* 193 */       arrayOfByte = Files.readAllBytes(this.b.toPath());
/* 194 */     } catch (IOException iOException) {
/* 195 */       JOptionPane.showMessageDialog(this, "Não foi possível localizar o certificado no caminho " + this.b.getAbsolutePath(), "Mensagem", 0);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 201 */     if (arrayOfByte.length == 0) {
/* 202 */       JOptionPane.showMessageDialog(this, "Erro ao carregar o certificado, por favor tente novamente. " + this.b.getAbsolutePath(), "Mensagem", 0);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 207 */     String str1 = Base64.getEncoder().encodeToString(arrayOfByte);
/* 208 */     String str2 = String.valueOf(this.b.getPassword());
/* 209 */     this.c.a(str1, str2, this.b.getAbsolutePath());
/* 210 */     JOptionPane.showMessageDialog(this, "Certificado importado com sucesso!", "Mensagem", 1);
/* 211 */     dispose();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\n\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */