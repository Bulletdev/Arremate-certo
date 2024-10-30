/*    */ package org.c.a.b.r;
/*    */ 
/*    */ import java.io.FilterReader;
/*    */ import java.io.IOException;
/*    */ import java.io.PushbackReader;
/*    */ import java.io.Reader;
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
/*    */ public class c
/*    */   extends FilterReader
/*    */ {
/*    */   private static final int iJ = -1;
/*    */   private static final char t = '﻿';
/*    */   
/*    */   public c(Reader paramReader) throws IOException {
/* 37 */     super(new PushbackReader(paramReader));
/* 38 */     PushbackReader pushbackReader = (PushbackReader)this.in;
/* 39 */     int i = pushbackReader.read();
/* 40 */     if (i != -1 && i != 65279)
/* 41 */       pushbackReader.unread(i); 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\r\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */