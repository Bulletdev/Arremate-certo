/*    */ package org.h2.jdbcx;
/*    */ 
/*    */ import java.util.Hashtable;
/*    */ import javax.naming.Context;
/*    */ import javax.naming.Name;
/*    */ import javax.naming.Reference;
/*    */ import javax.naming.spi.ObjectFactory;
/*    */ import org.h2.Driver;
/*    */ import org.h2.engine.SysProperties;
/*    */ import org.h2.message.Trace;
/*    */ import org.h2.message.TraceSystem;
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
/*    */ public class JdbcDataSourceFactory
/*    */   implements ObjectFactory
/*    */ {
/*    */   private static TraceSystem cachedTraceSystem;
/*    */   
/*    */   static {
/* 30 */     Driver.load();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 37 */   private final Trace trace = getTraceSystem().getTrace(15);
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
/*    */   public synchronized Object getObjectInstance(Object paramObject, Name paramName, Context paramContext, Hashtable<?, ?> paramHashtable) {
/* 55 */     if (this.trace.isDebugEnabled()) {
/* 56 */       this.trace.debug("getObjectInstance obj={0} name={1} nameCtx={2} environment={3}", new Object[] { paramObject, paramName, paramContext, paramHashtable });
/*    */     }
/*    */     
/* 59 */     if (paramObject instanceof Reference) {
/* 60 */       Reference reference = (Reference)paramObject;
/* 61 */       if (reference.getClassName().equals(JdbcDataSource.class.getName())) {
/* 62 */         JdbcDataSource jdbcDataSource = new JdbcDataSource();
/* 63 */         jdbcDataSource.setURL((String)reference.get("url").getContent());
/* 64 */         jdbcDataSource.setUser((String)reference.get("user").getContent());
/* 65 */         jdbcDataSource.setPassword((String)reference.get("password").getContent());
/* 66 */         jdbcDataSource.setDescription((String)reference.get("description").getContent());
/* 67 */         String str = (String)reference.get("loginTimeout").getContent();
/* 68 */         jdbcDataSource.setLoginTimeout(Integer.parseInt(str));
/* 69 */         return jdbcDataSource;
/*    */       } 
/*    */     } 
/* 72 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static TraceSystem getTraceSystem() {
/* 79 */     synchronized (JdbcDataSourceFactory.class) {
/* 80 */       if (cachedTraceSystem == null) {
/* 81 */         cachedTraceSystem = new TraceSystem(SysProperties.CLIENT_TRACE_DIRECTORY + "h2datasource" + ".trace.db");
/*    */ 
/*    */         
/* 84 */         cachedTraceSystem.setLevelFile(SysProperties.DATASOURCE_TRACE_LEVEL);
/*    */       } 
/* 86 */       return cachedTraceSystem;
/*    */     } 
/*    */   }
/*    */   
/*    */   Trace getTrace() {
/* 91 */     return this.trace;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\jdbcx\JdbcDataSourceFactory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */