/*     */ package org.apache.xmlbeans.xml.stream;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import org.apache.xmlbeans.xml.stream.utils.NestedThrowable;
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
/*     */ public class XMLStreamException
/*     */   extends IOException
/*     */   implements NestedThrowable
/*     */ {
/*     */   protected Throwable th;
/*     */   
/*     */   public XMLStreamException() {}
/*     */   
/*     */   public XMLStreamException(String paramString) {
/*  40 */     super(paramString);
/*     */   }
/*     */   
/*     */   public XMLStreamException(Throwable paramThrowable) {
/*  44 */     this.th = paramThrowable;
/*     */   }
/*     */ 
/*     */   
/*     */   public XMLStreamException(String paramString, Throwable paramThrowable) {
/*  49 */     super(paramString);
/*  50 */     this.th = paramThrowable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Throwable getNestedException() {
/*  59 */     return getNested();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getMessage() {
/*  64 */     String str = super.getMessage();
/*     */     
/*  66 */     if (str == null && this.th != null) {
/*  67 */       return this.th.getMessage();
/*     */     }
/*  69 */     return str;
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
/*     */   public Throwable getNested() {
/*  83 */     return this.th;
/*     */   }
/*     */   
/*     */   public String superToString() {
/*  87 */     return super.toString();
/*     */   }
/*     */   
/*     */   public void superPrintStackTrace(PrintStream paramPrintStream) {
/*  91 */     super.printStackTrace(paramPrintStream);
/*     */   }
/*     */   
/*     */   public void superPrintStackTrace(PrintWriter paramPrintWriter) {
/*  95 */     super.printStackTrace(paramPrintWriter);
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
/*     */   public String toString() {
/* 107 */     return NestedThrowable.Util.toString(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void printStackTrace(PrintStream paramPrintStream) {
/* 117 */     NestedThrowable.Util.printStackTrace(this, paramPrintStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void printStackTrace(PrintWriter paramPrintWriter) {
/* 127 */     NestedThrowable.Util.printStackTrace(this, paramPrintWriter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void printStackTrace() {
/* 137 */     printStackTrace(System.err);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\xml\stream\XMLStreamException.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */