/*    */ package br.com.arremate.m;
/*    */ 
/*    */ import br.com.arremate.a.a.c;
/*    */ import br.com.arremate.f.z;
/*    */ import br.com.arremate.n.n;
/*    */ import javax.swing.JEditorPane;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JOptionPane;
/*    */ import javax.swing.event.HyperlinkEvent;
/*    */ import org.e.i;
/*    */ 
/*    */ public final class k
/*    */ {
/*    */   public static final String eC;
/*    */   
/*    */   static {
/* 17 */     StringBuilder stringBuilder = new StringBuilder();
/* 18 */     stringBuilder.append("<html>");
/* 19 */     stringBuilder.append("<p>Erro ao realizar operação. Entre em contato conosco através de um dos canais abaixo:<br /><br /></p>");
/* 20 */     stringBuilder.append("<p>Atendimento via Chat: <a href=\"");
/* 21 */     stringBuilder.append(z.g.getUrl());
/* 22 */     stringBuilder.append("\">Clique aqui</a></p>");
/* 23 */     stringBuilder.append("<p>Email: suporte@effecti.com.br</p>");
/* 24 */     stringBuilder.append("</html>");
/* 25 */     eC = stringBuilder.toString();
/*    */   }
/*    */   
/*    */   private static JEditorPane a(String paramString1, String paramString2) {
/* 29 */     JEditorPane jEditorPane = new JEditorPane("text/html", paramString1);
/*    */     
/* 31 */     jEditorPane.addHyperlinkListener(paramHyperlinkEvent -> {
/*    */           if (paramHyperlinkEvent.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED)) {
/* 33 */             y.l((paramString == null || paramString.isEmpty()) ? paramHyperlinkEvent.getURL().toString() : paramString);
/*    */           }
/*    */         });
/* 36 */     jEditorPane.setEditable(false);
/* 37 */     jEditorPane.setBackground((new JLabel()).getBackground());
/*    */     
/* 39 */     return jEditorPane;
/*    */   }
/*    */   
/*    */   public static JEditorPane a(String paramString) {
/* 43 */     return a(paramString, (String)null);
/*    */   }
/*    */   
/*    */   public static JEditorPane b(String paramString) {
/* 47 */     return a(paramString, n.fM);
/*    */   }
/*    */   
/*    */   public static void cM() {
/* 51 */     if (c.a().f()) {
/* 52 */       cN();
/*    */     } else {
/* 54 */       JOptionPane.showMessageDialog(null, b(eC), "Falha na Comunicação", 0);
/*    */     } 
/*    */   }
/*    */   
/*    */   private static void cN() {
/* 59 */     JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar a operação.", "Falha na Comunicação", 0);
/*    */   }
/*    */   
/*    */   public static boolean n(i parami) {
/* 63 */     if (parami == null) {
/* 64 */       cM();
/* 65 */       return false;
/*    */     } 
/*    */     
/* 68 */     String str = parami.getString("message");
/* 69 */     if (!str.isEmpty()) {
/* 70 */       JOptionPane.showMessageDialog(null, str, "Problema com verificação da empresa", 0);
/* 71 */       return false;
/*    */     } 
/*    */     
/* 74 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\m\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */