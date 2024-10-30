/*    */ package org.apache.commons.net.nntp;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.util.Iterator;
/*    */ import java.util.NoSuchElementException;
/*    */ import org.apache.commons.net.io.DotTerminatedMessageReader;
/*    */ import org.apache.commons.net.io.Util;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class ReplyIterator
/*    */   implements Iterable<String>, Iterator<String>
/*    */ {
/*    */   private final BufferedReader reader;
/*    */   private String line;
/*    */   private Exception savedException;
/*    */   
/*    */   ReplyIterator(BufferedReader paramBufferedReader, boolean paramBoolean) throws IOException {
/* 49 */     this.reader = paramBoolean ? (BufferedReader)new DotTerminatedMessageReader(paramBufferedReader) : paramBufferedReader;
/* 50 */     this.line = this.reader.readLine();
/* 51 */     if (this.line == null) {
/* 52 */       Util.closeQuietly(this.reader);
/*    */     }
/*    */   }
/*    */   
/*    */   ReplyIterator(BufferedReader paramBufferedReader) throws IOException {
/* 57 */     this(paramBufferedReader, true);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hasNext() {
/* 62 */     if (this.savedException != null) {
/* 63 */       throw new NoSuchElementException(this.savedException.toString());
/*    */     }
/* 65 */     return (this.line != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public String next() throws NoSuchElementException {
/* 70 */     if (this.savedException != null) {
/* 71 */       throw new NoSuchElementException(this.savedException.toString());
/*    */     }
/* 73 */     String str = this.line;
/* 74 */     if (str == null) {
/* 75 */       throw new NoSuchElementException();
/*    */     }
/*    */     try {
/* 78 */       this.line = this.reader.readLine();
/* 79 */       if (this.line == null) {
/* 80 */         Util.closeQuietly(this.reader);
/*    */       }
/* 82 */     } catch (IOException iOException) {
/* 83 */       this.savedException = iOException;
/* 84 */       Util.closeQuietly(this.reader);
/*    */     } 
/* 86 */     return str;
/*    */   }
/*    */ 
/*    */   
/*    */   public void remove() {
/* 91 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */   
/*    */   public Iterator<String> iterator() {
/* 96 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\nntp\ReplyIterator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */