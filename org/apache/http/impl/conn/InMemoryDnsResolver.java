/*    */ package org.apache.http.impl.conn;
/*    */ 
/*    */ import java.net.InetAddress;
/*    */ import java.net.UnknownHostException;
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.apache.http.conn.DnsResolver;
/*    */ import org.apache.http.util.Args;
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
/*    */ 
/*    */ public class InMemoryDnsResolver
/*    */   implements DnsResolver
/*    */ {
/* 48 */   private final Log log = LogFactory.getLog(InMemoryDnsResolver.class);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final Map<String, InetAddress[]> dnsMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public InMemoryDnsResolver() {
/* 61 */     this.dnsMap = (Map)new ConcurrentHashMap<String, InetAddress>();
/*    */   }
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
/*    */   public void add(String paramString, InetAddress... paramVarArgs) {
/* 75 */     Args.notNull(paramString, "Host name");
/* 76 */     Args.notNull(paramVarArgs, "Array of IP addresses");
/* 77 */     this.dnsMap.put(paramString, paramVarArgs);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public InetAddress[] resolve(String paramString) throws UnknownHostException {
/* 85 */     InetAddress[] arrayOfInetAddress = this.dnsMap.get(paramString);
/* 86 */     if (this.log.isInfoEnabled()) {
/* 87 */       this.log.info("Resolving " + paramString + " to " + Arrays.deepToString((Object[])arrayOfInetAddress));
/*    */     }
/* 89 */     if (arrayOfInetAddress == null) {
/* 90 */       throw new UnknownHostException(paramString + " cannot be resolved");
/*    */     }
/* 92 */     return arrayOfInetAddress;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\InMemoryDnsResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */