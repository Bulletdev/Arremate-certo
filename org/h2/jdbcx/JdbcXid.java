/*    */ package org.h2.jdbcx;
/*    */ 
/*    */ import java.util.StringTokenizer;
/*    */ import javax.transaction.xa.Xid;
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.message.TraceObject;
/*    */ import org.h2.util.StringUtils;
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
/*    */ public class JdbcXid
/*    */   extends TraceObject
/*    */   implements Xid
/*    */ {
/*    */   private static final String PREFIX = "XID";
/*    */   private final int formatId;
/*    */   private final byte[] branchQualifier;
/*    */   private final byte[] globalTransactionId;
/*    */   
/*    */   JdbcXid(JdbcDataSourceFactory paramJdbcDataSourceFactory, int paramInt, String paramString) {
/* 28 */     setTrace(paramJdbcDataSourceFactory.getTrace(), 15, paramInt);
/*    */     try {
/* 30 */       StringTokenizer stringTokenizer = new StringTokenizer(paramString, "_");
/* 31 */       String str = stringTokenizer.nextToken();
/* 32 */       if (!"XID".equals(str)) {
/* 33 */         throw DbException.get(90101, paramString);
/*    */       }
/* 35 */       this.formatId = Integer.parseInt(stringTokenizer.nextToken());
/* 36 */       this.branchQualifier = StringUtils.convertHexToBytes(stringTokenizer.nextToken());
/* 37 */       this.globalTransactionId = StringUtils.convertHexToBytes(stringTokenizer.nextToken());
/* 38 */     } catch (RuntimeException runtimeException) {
/* 39 */       throw DbException.get(90101, paramString);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String toString(Xid paramXid) {
/* 47 */     StringBuilder stringBuilder = new StringBuilder("XID");
/* 48 */     stringBuilder.append('_').append(paramXid.getFormatId()).append('_').append(StringUtils.convertBytesToHex(paramXid.getBranchQualifier())).append('_').append(StringUtils.convertBytesToHex(paramXid.getGlobalTransactionId()));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 54 */     return stringBuilder.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getFormatId() {
/* 64 */     debugCodeCall("getFormatId");
/* 65 */     return this.formatId;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public byte[] getBranchQualifier() {
/* 75 */     debugCodeCall("getBranchQualifier");
/* 76 */     return this.branchQualifier;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public byte[] getGlobalTransactionId() {
/* 86 */     debugCodeCall("getGlobalTransactionId");
/* 87 */     return this.globalTransactionId;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\jdbcx\JdbcXid.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */