/*     */ package oshi.jna.platform.mac;
/*     */ 
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.Structure.FieldOrder;
/*     */ import com.sun.jna.Union;
/*     */ import com.sun.jna.platform.mac.SystemB;
/*     */ import oshi.jna.platform.unix.CLibrary;
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
/*     */ public interface SystemB
/*     */   extends SystemB, CLibrary
/*     */ {
/*  39 */   public static final SystemB INSTANCE = (SystemB)Native.load("System", SystemB.class);
/*     */   public static final int PROC_PIDLISTFDS = 1;
/*     */   public static final int PROX_FDTYPE_SOCKET = 2;
/*     */   public static final int PROC_PIDFDSOCKETINFO = 3;
/*     */   public static final int TSI_T_NTIMERS = 4;
/*     */   public static final int SOCKINFO_IN = 1;
/*     */   public static final int SOCKINFO_TCP = 2;
/*     */   public static final int UTX_USERSIZE = 256;
/*     */   public static final int UTX_LINESIZE = 32;
/*     */   public static final int UTX_IDSIZE = 4;
/*     */   public static final int UTX_HOSTSIZE = 256;
/*     */   public static final int AF_INET = 2;
/*     */   public static final int AF_INET6 = 30;
/*     */   
/*     */   MacUtmpx getutxent();
/*     */   
/*     */   int proc_pidfdinfo(int paramInt1, int paramInt2, int paramInt3, Structure paramStructure, int paramInt4);
/*     */   
/*     */   @FieldOrder({"ut_user", "ut_id", "ut_line", "ut_pid", "ut_type", "ut_tv", "ut_host", "ut_pad"})
/*     */   public static class MacUtmpx
/*     */     extends Structure
/*     */   {
/*  61 */     public byte[] ut_user = new byte[256];
/*  62 */     public byte[] ut_id = new byte[4];
/*  63 */     public byte[] ut_line = new byte[32];
/*     */     public int ut_pid;
/*     */     public short ut_type;
/*     */     public SystemB.Timeval ut_tv;
/*  67 */     public byte[] ut_host = new byte[256];
/*  68 */     public byte[] ut_pad = new byte[16];
/*     */   }
/*     */ 
/*     */   
/*     */   @FieldOrder({"proc_fd", "proc_fdtype"})
/*     */   public static class ProcFdInfo
/*     */     extends Structure
/*     */   {
/*     */     public int proc_fd;
/*     */     
/*     */     public int proc_fdtype;
/*     */   }
/*     */ 
/*     */   
/*     */   @FieldOrder({"insi_fport", "insi_lport", "insi_gencnt", "insi_flags", "insi_flow", "insi_vflag", "insi_ip_ttl", "rfu_1", "insi_faddr", "insi_laddr", "insi_v4", "insi_v6"})
/*     */   public static class InSockInfo
/*     */     extends Structure
/*     */   {
/*     */     public int insi_fport;
/*     */     
/*     */     public int insi_lport;
/*     */     
/*     */     public long insi_gencnt;
/*     */     public int insi_flags;
/*     */     public int insi_flow;
/*     */     public byte insi_vflag;
/*     */     public byte insi_ip_ttl;
/*     */     public int rfu_1;
/*  96 */     public int[] insi_faddr = new int[4];
/*  97 */     public int[] insi_laddr = new int[4];
/*     */     public byte insi_v4;
/*  99 */     public byte[] insi_v6 = new byte[9];
/*     */   }
/*     */ 
/*     */   
/*     */   @FieldOrder({"tcpsi_ini", "tcpsi_state", "tcpsi_timer", "tcpsi_mss", "tcpsi_flags", "rfu_1", "tcpsi_tp"})
/*     */   public static class TcpSockInfo
/*     */     extends Structure
/*     */   {
/*     */     public SystemB.InSockInfo tcpsi_ini;
/*     */     public int tcpsi_state;
/* 109 */     public int[] tcpsi_timer = new int[4];
/*     */     
/*     */     public int tcpsi_mss;
/*     */     
/*     */     public int tcpsi_flags;
/*     */     
/*     */     public int rfu_1;
/*     */     public long tcpsi_tp;
/*     */   }
/*     */   
/*     */   @FieldOrder({"soi_stat", "soi_so", "soi_pcb", "soi_type", "soi_protocol", "soi_family", "soi_options", "soi_linger", "soi_state", "soi_qlen", "soi_incqlen", "soi_qlimit", "soi_timeo", "soi_error", "soi_oobmark", "soi_rcv", "soi_snd", "soi_kind", "rfu_1", "soi_proto"})
/*     */   public static class SocketInfo
/*     */     extends Structure
/*     */   {
/* 123 */     public long[] soi_stat = new long[17];
/*     */     public long soi_so;
/*     */     public long soi_pcb;
/*     */     public int soi_type;
/*     */     public int soi_protocol;
/*     */     public int soi_family;
/*     */     public short soi_options;
/*     */     public short soi_linger;
/*     */     public short soi_state;
/*     */     public short soi_qlen;
/*     */     public short soi_incqlen;
/*     */     public short soi_qlimit;
/*     */     public short soi_timeo;
/*     */     public short soi_error;
/*     */     public int soi_oobmark;
/* 138 */     public int[] soi_rcv = new int[6];
/* 139 */     public int[] soi_snd = new int[6];
/*     */     
/*     */     public int soi_kind;
/*     */     
/*     */     public int rfu_1;
/*     */     
/*     */     public SystemB.Pri soi_proto;
/*     */   }
/*     */ 
/*     */   
/*     */   @FieldOrder({"fi_openflags", "fi_status", "fi_offset", "fi_type", "fi_guardflags"})
/*     */   public static class ProcFileInfo
/*     */     extends Structure
/*     */   {
/*     */     public int fi_openflags;
/*     */     public int fi_status;
/*     */     public long fi_offset;
/*     */     public int fi_type;
/*     */     public int fi_guardflags;
/*     */   }
/*     */   
/*     */   @FieldOrder({"pfi", "psi"})
/*     */   public static class SocketFdInfo
/*     */     extends Structure
/*     */   {
/*     */     public SystemB.ProcFileInfo pfi;
/*     */     public SystemB.SocketInfo psi;
/*     */   }
/*     */   
/*     */   public static class Pri
/*     */     extends Union
/*     */   {
/*     */     public SystemB.InSockInfo pri_in;
/*     */     public SystemB.TcpSockInfo pri_tcp;
/* 173 */     public byte[] max_size = new byte[524];
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\jna\platform\mac\SystemB.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */