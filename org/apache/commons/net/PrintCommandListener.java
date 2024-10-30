/*     */ package org.apache.commons.net;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
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
/*     */ public class PrintCommandListener
/*     */   implements ProtocolCommandListener
/*     */ {
/*     */   private final PrintWriter writer;
/*     */   private final boolean nologin;
/*     */   private final char eolMarker;
/*     */   private final boolean directionMarker;
/*     */   
/*     */   public PrintCommandListener(PrintStream paramPrintStream) {
/*  47 */     this(new PrintWriter(paramPrintStream));
/*     */   }
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
/*     */   public PrintCommandListener(PrintStream paramPrintStream, boolean paramBoolean) {
/*  60 */     this(new PrintWriter(paramPrintStream), paramBoolean);
/*     */   }
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
/*     */   public PrintCommandListener(PrintStream paramPrintStream, boolean paramBoolean, char paramChar) {
/*  74 */     this(new PrintWriter(paramPrintStream), paramBoolean, paramChar);
/*     */   }
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
/*     */   public PrintCommandListener(PrintStream paramPrintStream, boolean paramBoolean1, char paramChar, boolean paramBoolean2) {
/*  90 */     this(new PrintWriter(paramPrintStream), paramBoolean1, paramChar, paramBoolean2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PrintCommandListener(PrintWriter paramPrintWriter) {
/* 100 */     this(paramPrintWriter, false);
/*     */   }
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
/*     */   public PrintCommandListener(PrintWriter paramPrintWriter, boolean paramBoolean) {
/* 113 */     this(paramPrintWriter, paramBoolean, false);
/*     */   }
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
/*     */   public PrintCommandListener(PrintWriter paramPrintWriter, boolean paramBoolean, char paramChar) {
/* 128 */     this(paramPrintWriter, paramBoolean, paramChar, false);
/*     */   }
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
/*     */   public PrintCommandListener(PrintWriter paramPrintWriter, boolean paramBoolean1, char paramChar, boolean paramBoolean2) {
/* 144 */     this.writer = paramPrintWriter;
/* 145 */     this.nologin = paramBoolean1;
/* 146 */     this.eolMarker = paramChar;
/* 147 */     this.directionMarker = paramBoolean2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void protocolCommandSent(ProtocolCommandEvent paramProtocolCommandEvent) {
/* 153 */     if (this.directionMarker) {
/* 154 */       this.writer.print("> ");
/*     */     }
/* 156 */     if (this.nologin) {
/* 157 */       String str = paramProtocolCommandEvent.getCommand();
/* 158 */       if ("PASS".equalsIgnoreCase(str) || "USER".equalsIgnoreCase(str)) {
/* 159 */         this.writer.print(str);
/* 160 */         this.writer.println(" *******");
/*     */       } else {
/* 162 */         String str1 = "LOGIN";
/* 163 */         if ("LOGIN".equalsIgnoreCase(str)) {
/* 164 */           String str2 = paramProtocolCommandEvent.getMessage();
/* 165 */           str2 = str2.substring(0, str2.indexOf("LOGIN") + "LOGIN".length());
/* 166 */           this.writer.print(str2);
/* 167 */           this.writer.println(" *******");
/*     */         } else {
/* 169 */           this.writer.print(getPrintableString(paramProtocolCommandEvent.getMessage()));
/*     */         } 
/*     */       } 
/*     */     } else {
/* 173 */       this.writer.print(getPrintableString(paramProtocolCommandEvent.getMessage()));
/*     */     } 
/* 175 */     this.writer.flush();
/*     */   }
/*     */   
/*     */   private String getPrintableString(String paramString) {
/* 179 */     if (this.eolMarker == '\000') {
/* 180 */       return paramString;
/*     */     }
/* 182 */     int i = paramString.indexOf("\r\n");
/* 183 */     if (i > 0) {
/* 184 */       StringBuilder stringBuilder = new StringBuilder();
/* 185 */       stringBuilder.append(paramString.substring(0, i));
/* 186 */       stringBuilder.append(this.eolMarker);
/* 187 */       stringBuilder.append(paramString.substring(i));
/* 188 */       return stringBuilder.toString();
/*     */     } 
/* 190 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void protocolReplyReceived(ProtocolCommandEvent paramProtocolCommandEvent) {
/* 196 */     if (this.directionMarker) {
/* 197 */       this.writer.print("< ");
/*     */     }
/* 199 */     this.writer.print(paramProtocolCommandEvent.getMessage());
/* 200 */     this.writer.flush();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\PrintCommandListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */