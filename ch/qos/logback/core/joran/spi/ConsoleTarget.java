/*     */ package ch.qos.logback.core.joran.spi;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
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
/*     */ public enum ConsoleTarget
/*     */ {
/*  29 */   SystemOut("System.out", new OutputStream()
/*     */     {
/*     */       public void write(int param1Int) throws IOException {
/*  32 */         System.out.write(param1Int);
/*     */       }
/*     */ 
/*     */       
/*     */       public void write(byte[] param1ArrayOfbyte) throws IOException {
/*  37 */         System.out.write(param1ArrayOfbyte);
/*     */       }
/*     */ 
/*     */       
/*     */       public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
/*  42 */         System.out.write(param1ArrayOfbyte, param1Int1, param1Int2);
/*     */       }
/*     */ 
/*     */       
/*     */       public void flush() throws IOException {
/*  47 */         System.out.flush();
/*     */       }
/*     */     }),
/*     */   
/*  51 */   SystemErr("System.err", new OutputStream()
/*     */     {
/*     */       public void write(int param1Int) throws IOException {
/*  54 */         System.err.write(param1Int);
/*     */       }
/*     */ 
/*     */       
/*     */       public void write(byte[] param1ArrayOfbyte) throws IOException {
/*  59 */         System.err.write(param1ArrayOfbyte);
/*     */       }
/*     */ 
/*     */       
/*     */       public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
/*  64 */         System.err.write(param1ArrayOfbyte, param1Int1, param1Int2);
/*     */       }
/*     */ 
/*     */       
/*     */       public void flush() throws IOException {
/*  69 */         System.err.flush();
/*     */       }
/*     */     });
/*     */   
/*     */   public static ConsoleTarget findByName(String paramString) {
/*  74 */     for (ConsoleTarget consoleTarget : values()) {
/*  75 */       if (consoleTarget.name.equalsIgnoreCase(paramString)) {
/*  76 */         return consoleTarget;
/*     */       }
/*     */     } 
/*  79 */     return null;
/*     */   }
/*     */   
/*     */   private final String name;
/*     */   private final OutputStream stream;
/*     */   
/*     */   ConsoleTarget(String paramString1, OutputStream paramOutputStream) {
/*  86 */     this.name = paramString1;
/*  87 */     this.stream = paramOutputStream;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  91 */     return this.name;
/*     */   }
/*     */   
/*     */   public OutputStream getStream() {
/*  95 */     return this.stream;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 100 */     return this.name;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\spi\ConsoleTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */