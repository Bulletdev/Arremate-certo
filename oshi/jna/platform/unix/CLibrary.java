/*    */ package oshi.jna.platform.unix;
/*    */ 
/*    */ import com.sun.jna.Library;
/*    */ import com.sun.jna.NativeLong;
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.Structure;
/*    */ import com.sun.jna.Structure.FieldOrder;
/*    */ import com.sun.jna.platform.unix.LibCAPI;
/*    */ import com.sun.jna.ptr.PointerByReference;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface CLibrary
/*    */   extends Library, LibCAPI
/*    */ {
/*    */   public static final int AI_CANONNAME = 2;
/*    */   public static final int UT_LINESIZE = 32;
/*    */   public static final int UT_NAMESIZE = 32;
/*    */   public static final int UT_HOSTSIZE = 256;
/*    */   public static final int LOGIN_PROCESS = 6;
/*    */   public static final int USER_PROCESS = 7;
/*    */   
/*    */   int getpid();
/*    */   
/*    */   int getaddrinfo(String paramString1, String paramString2, Addrinfo paramAddrinfo, PointerByReference paramPointerByReference);
/*    */   
/*    */   void freeaddrinfo(Pointer paramPointer);
/*    */   
/*    */   String gai_strerror(int paramInt);
/*    */   
/*    */   void setutxent();
/*    */   
/*    */   void endutxent();
/*    */   
/*    */   int sysctl(int[] paramArrayOfint, int paramInt, Pointer paramPointer1, LibCAPI.size_t.ByReference paramByReference, Pointer paramPointer2, LibCAPI.size_t paramsize_t);
/*    */   
/*    */   int sysctlbyname(String paramString, Pointer paramPointer1, LibCAPI.size_t.ByReference paramByReference, Pointer paramPointer2, LibCAPI.size_t paramsize_t);
/*    */   
/*    */   int sysctlnametomib(String paramString, Pointer paramPointer, LibCAPI.size_t.ByReference paramByReference);
/*    */   
/*    */   int open(String paramString, int paramInt);
/*    */   
/*    */   LibCAPI.ssize_t pread(int paramInt, Pointer paramPointer, LibCAPI.size_t paramsize_t, NativeLong paramNativeLong);
/*    */   
/*    */   @FieldOrder({"sa_family", "sa_data"})
/*    */   public static class Sockaddr
/*    */     extends Structure
/*    */   {
/*    */     public short sa_family;
/* 52 */     public byte[] sa_data = new byte[14];
/*    */     
/*    */     public static class ByReference
/*    */       extends Sockaddr
/*    */       implements Structure.ByReference {}
/*    */   }
/*    */   
/*    */   @FieldOrder({"ai_flags", "ai_family", "ai_socktype", "ai_protocol", "ai_addrlen", "ai_addr", "ai_canonname", "ai_next"})
/*    */   public static class Addrinfo
/*    */     extends Structure {
/*    */     public int ai_flags;
/*    */     public int ai_family;
/*    */     public int ai_socktype;
/*    */     public int ai_protocol;
/*    */     public int ai_addrlen;
/*    */     public CLibrary.Sockaddr.ByReference ai_addr;
/*    */     public String ai_canonname;
/*    */     public ByReference ai_next;
/*    */     
/*    */     public static class ByReference
/*    */       extends Addrinfo implements Structure.ByReference {}
/*    */     
/*    */     public Addrinfo() {}
/*    */     
/*    */     public Addrinfo(Pointer param1Pointer) {
/* 77 */       super(param1Pointer);
/* 78 */       read();
/*    */     }
/*    */   }
/*    */   
/*    */   public static class BsdTcpstat {
/*    */     public int tcps_connattempt;
/*    */     public int tcps_accepts;
/*    */     public int tcps_drops;
/*    */     public int tcps_conndrops;
/*    */     public int tcps_sndpack;
/*    */     public int tcps_sndrexmitpack;
/*    */     public int tcps_rcvpack;
/*    */     public int tcps_rcvbadsum;
/*    */     public int tcps_rcvbadoff;
/*    */     public int tcps_rcvmemdrop;
/*    */     public int tcps_rcvshort;
/*    */   }
/*    */   
/*    */   public static class BsdUdpstat {
/*    */     public int udps_ipackets;
/*    */     public int udps_hdrops;
/*    */     public int udps_badsum;
/*    */     public int udps_badlen;
/*    */     public int udps_opackets;
/*    */     public int udps_noportmcast;
/*    */     public int udps_rcv6_swcsum;
/*    */     public int udps_snd6_swcsum;
/*    */   }
/*    */   
/*    */   public static class BsdIpstat {
/*    */     public int ips_total;
/*    */     public int ips_badsum;
/*    */     public int ips_tooshort;
/*    */     public int ips_toosmall;
/*    */     public int ips_badhlen;
/*    */     public int ips_badlen;
/*    */     public int ips_delivered;
/*    */   }
/*    */   
/*    */   public static class BsdIp6stat {
/*    */     public long ip6s_total;
/*    */     public long ip6s_localout;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\jna\platfor\\unix\CLibrary.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */