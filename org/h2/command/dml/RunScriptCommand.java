/*    */ package org.h2.command.dml;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStreamReader;
/*    */ import java.nio.charset.Charset;
/*    */ import org.h2.api.JavaObjectSerializer;
/*    */ import org.h2.command.Prepared;
/*    */ import org.h2.engine.Constants;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.expression.Expression;
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.result.ResultInterface;
/*    */ import org.h2.store.FileStore;
/*    */ import org.h2.store.LobStorageBackend;
/*    */ import org.h2.util.ScriptReader;
/*    */ import org.h2.util.SmallLRUCache;
/*    */ import org.h2.util.TempFileDeleter;
/*    */ import org.h2.value.CompareMode;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RunScriptCommand
/*    */   extends ScriptBase
/*    */ {
/*    */   private static final char UTF8_BOM = '﻿';
/* 33 */   private Charset charset = Constants.UTF8;
/*    */   
/*    */   public RunScriptCommand(Session paramSession) {
/* 36 */     super(paramSession);
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 41 */     this.session.getUser().checkAdmin();
/* 42 */     byte b = 0;
/*    */     try {
/* 44 */       openInput();
/* 45 */       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.in, this.charset));
/*    */       
/* 47 */       bufferedReader.mark(1);
/* 48 */       if (bufferedReader.read() != 65279) {
/* 49 */         bufferedReader.reset();
/*    */       }
/* 51 */       ScriptReader scriptReader = new ScriptReader(bufferedReader);
/*    */       while (true) {
/* 53 */         String str = scriptReader.readStatement();
/* 54 */         if (str == null) {
/*    */           break;
/*    */         }
/* 57 */         execute(str);
/* 58 */         b++;
/* 59 */         if ((b & 0x7F) == 0) {
/* 60 */           checkCanceled();
/*    */         }
/*    */       } 
/* 63 */       bufferedReader.close();
/* 64 */     } catch (IOException iOException) {
/* 65 */       throw DbException.convertIOException(iOException, null);
/*    */     } finally {
/* 67 */       closeIO();
/*    */     } 
/* 69 */     return b;
/*    */   }
/*    */   
/*    */   private void execute(String paramString) {
/*    */     try {
/* 74 */       Prepared prepared = this.session.prepare(paramString);
/* 75 */       if (prepared.isQuery()) {
/* 76 */         prepared.query(0);
/*    */       } else {
/* 78 */         prepared.update();
/*    */       } 
/* 80 */       if (this.session.getAutoCommit()) {
/* 81 */         this.session.commit(false);
/*    */       }
/* 83 */     } catch (DbException dbException) {
/* 84 */       throw dbException.addSQL(paramString);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void setCharset(Charset paramCharset) {
/* 89 */     this.charset = paramCharset;
/*    */   }
/*    */ 
/*    */   
/*    */   public ResultInterface queryMeta() {
/* 94 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 99 */     return 64;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\dml\RunScriptCommand.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */