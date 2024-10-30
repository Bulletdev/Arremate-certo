/*      */ package org.apache.commons.net.ftp;
/*      */ 
/*      */ import java.io.BufferedInputStream;
/*      */ import java.io.BufferedOutputStream;
/*      */ import java.io.BufferedReader;
/*      */ import java.io.BufferedWriter;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.InputStreamReader;
/*      */ import java.io.OutputStream;
/*      */ import java.io.OutputStreamWriter;
/*      */ import java.io.Reader;
/*      */ import java.net.InetAddress;
/*      */ import java.net.InetSocketAddress;
/*      */ import java.net.ServerSocket;
/*      */ import java.net.Socket;
/*      */ import java.net.SocketException;
/*      */ import java.net.SocketTimeoutException;
/*      */ import java.net.UnknownHostException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Calendar;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Locale;
/*      */ import java.util.Properties;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import java.util.regex.Matcher;
/*      */ import java.util.regex.Pattern;
/*      */ import org.apache.commons.net.MalformedServerReplyException;
/*      */ import org.apache.commons.net.ftp.parser.DefaultFTPFileEntryParserFactory;
/*      */ import org.apache.commons.net.ftp.parser.FTPFileEntryParserFactory;
/*      */ import org.apache.commons.net.ftp.parser.MLSxEntryParser;
/*      */ import org.apache.commons.net.io.CRLFLineReader;
/*      */ import org.apache.commons.net.io.CopyStreamAdapter;
/*      */ import org.apache.commons.net.io.CopyStreamEvent;
/*      */ import org.apache.commons.net.io.CopyStreamListener;
/*      */ import org.apache.commons.net.io.FromNetASCIIInputStream;
/*      */ import org.apache.commons.net.io.SocketInputStream;
/*      */ import org.apache.commons.net.io.SocketOutputStream;
/*      */ import org.apache.commons.net.io.ToNetASCIIOutputStream;
/*      */ import org.apache.commons.net.io.Util;
/*      */ import org.apache.commons.net.util.NetConstants;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class FTPClient
/*      */   extends FTP
/*      */   implements Configurable
/*      */ {
/*      */   public static final String FTP_SYSTEM_TYPE = "org.apache.commons.net.ftp.systemType";
/*      */   public static final String FTP_SYSTEM_TYPE_DEFAULT = "org.apache.commons.net.ftp.systemType.default";
/*      */   public static final String SYSTEM_TYPE_PROPERTIES = "/systemType.properties";
/*      */   public static final int ACTIVE_LOCAL_DATA_CONNECTION_MODE = 0;
/*      */   public static final int ACTIVE_REMOTE_DATA_CONNECTION_MODE = 1;
/*      */   public static final int PASSIVE_LOCAL_DATA_CONNECTION_MODE = 2;
/*      */   public static final int PASSIVE_REMOTE_DATA_CONNECTION_MODE = 3;
/*      */   
/*      */   private static class CSL
/*      */     implements CopyStreamListener
/*      */   {
/*      */     private final FTPClient parent;
/*      */     private final long idleMillis;
/*      */     private final int currentSoTimeoutMillis;
/*  306 */     private long timeMillis = System.currentTimeMillis();
/*      */     private int notAcked;
/*      */     private int acksAcked;
/*      */     private int ioErrors;
/*      */     
/*      */     CSL(FTPClient param1FTPClient, long param1Long, int param1Int) throws SocketException {
/*  312 */       this.idleMillis = param1Long;
/*  313 */       this.parent = param1FTPClient;
/*  314 */       this.currentSoTimeoutMillis = param1FTPClient.getSoTimeout();
/*  315 */       param1FTPClient.setSoTimeout(param1Int);
/*      */     }
/*      */ 
/*      */     
/*      */     public void bytesTransferred(CopyStreamEvent param1CopyStreamEvent) {
/*  320 */       bytesTransferred(param1CopyStreamEvent.getTotalBytesTransferred(), param1CopyStreamEvent.getBytesTransferred(), param1CopyStreamEvent.getStreamSize());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void bytesTransferred(long param1Long1, int param1Int, long param1Long2) {
/*  326 */       long l = System.currentTimeMillis();
/*  327 */       if (l - this.timeMillis > this.idleMillis) {
/*      */         try {
/*  329 */           this.parent.__noop();
/*  330 */           this.acksAcked++;
/*  331 */         } catch (SocketTimeoutException socketTimeoutException) {
/*  332 */           this.notAcked++;
/*  333 */         } catch (IOException iOException) {
/*  334 */           this.ioErrors++;
/*      */         } 
/*      */         
/*  337 */         this.timeMillis = l;
/*      */       } 
/*      */     }
/*      */     
/*      */     int[] cleanUp() throws IOException {
/*  342 */       int i = this.notAcked;
/*      */       try {
/*  344 */         while (this.notAcked > 0) {
/*  345 */           this.parent.getReply();
/*  346 */           this.notAcked--;
/*      */         } 
/*  348 */       } catch (SocketTimeoutException socketTimeoutException) {
/*      */       
/*      */       } finally {
/*  351 */         this.parent.setSoTimeout(this.currentSoTimeoutMillis);
/*      */       } 
/*  353 */       return new int[] { this.acksAcked, i, this.notAcked, this.ioErrors };
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface HostnameResolver
/*      */   {
/*      */     String resolve(String param1String) throws UnknownHostException;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class NatServerResolverImpl
/*      */     implements HostnameResolver
/*      */   {
/*      */     private final FTPClient client;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NatServerResolverImpl(FTPClient param1FTPClient) {
/*  377 */       this.client = param1FTPClient;
/*      */     }
/*      */ 
/*      */     
/*      */     public String resolve(String param1String) throws UnknownHostException {
/*  382 */       String str = param1String;
/*  383 */       InetAddress inetAddress = InetAddress.getByName(str);
/*      */       
/*  385 */       if (inetAddress.isSiteLocalAddress()) {
/*  386 */         InetAddress inetAddress1 = this.client.getRemoteAddress();
/*  387 */         if (!inetAddress1.isSiteLocalAddress()) {
/*  388 */           str = inetAddress1.getHostAddress();
/*      */         }
/*      */       } 
/*  391 */       return str;
/*      */     }
/*      */   }
/*      */   
/*      */   private static class PropertiesSingleton
/*      */   {
/*      */     static final Properties PROPERTIES;
/*      */     
/*      */     static {
/*  400 */       InputStream inputStream = FTPClient.class.getResourceAsStream("/systemType.properties");
/*  401 */       Properties properties = null;
/*  402 */       if (inputStream != null) {
/*  403 */         properties = new Properties();
/*      */         
/*  405 */         try { properties.load(inputStream); }
/*  406 */         catch (IOException iOException)
/*      */         
/*      */         { 
/*      */           try {
/*  410 */             inputStream.close();
/*  411 */           } catch (IOException iOException1) {} } finally { try { inputStream.close(); } catch (IOException iOException) {} }
/*      */       
/*      */       } 
/*      */ 
/*      */       
/*  416 */       PROPERTIES = properties;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int dataConnectionMode;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int dataTimeoutMillis;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int passivePort;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String passiveHost;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  491 */   private static final Pattern PARMS_PAT = Pattern.compile("(\\d{1,3},\\d{1,3},\\d{1,3},\\d{1,3}),(\\d{1,3}),(\\d{1,3})"); private final Random random;
/*      */   private int activeMinPort;
/*      */   private int activeMaxPort;
/*      */   
/*      */   private static Properties getOverrideProperties() {
/*  496 */     return PropertiesSingleton.PROPERTIES;
/*      */   }
/*      */   private InetAddress activeExternalHost; private InetAddress reportActiveExternalHost; private InetAddress passiveLocalHost; private int fileType;
/*      */   private int fileFormat;
/*      */   private int fileStructure;
/*      */   private int fileTransferMode;
/*      */   private boolean remoteVerificationEnabled;
/*      */   private long restartOffset;
/*      */   private FTPFileEntryParserFactory parserFactory;
/*      */   private int bufferSize;
/*      */   private int sendDataSocketBufferSize;
/*      */   private int receiveDataSocketBufferSize;
/*      */   private boolean listHiddenFiles;
/*      */   private boolean useEPSVwithIPv4;
/*      */   private String systemName;
/*      */   private FTPFileEntryParser entryParser;
/*      */   private String entryParserKey;
/*      */   private FTPClientConfig configuration;
/*      */   private CopyStreamListener copyStreamListener;
/*      */   private long controlKeepAliveTimeoutMillis;
/*      */   
/*      */   static String parsePathname(String paramString) {
/*  518 */     String str = paramString.substring(4);
/*  519 */     if (str.startsWith("\"")) {
/*  520 */       StringBuilder stringBuilder = new StringBuilder();
/*  521 */       boolean bool = false;
/*      */       
/*  523 */       for (byte b = 1; b < str.length(); b++) {
/*  524 */         char c = str.charAt(b);
/*  525 */         if (c == '"') {
/*  526 */           if (bool) {
/*  527 */             stringBuilder.append(c);
/*  528 */             bool = false;
/*      */           } else {
/*      */             
/*  531 */             bool = true;
/*      */           } 
/*      */         } else {
/*  534 */           if (bool) {
/*  535 */             return stringBuilder.toString();
/*      */           }
/*  537 */           stringBuilder.append(c);
/*      */         } 
/*      */       } 
/*  540 */       if (bool) {
/*  541 */         return stringBuilder.toString();
/*      */       }
/*      */     } 
/*      */     
/*  545 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  607 */   private int controlKeepAliveReplyTimeoutMillis = 1000;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int[] cslDebug;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  617 */   private HostnameResolver passiveNatWorkaroundStrategy = new NatServerResolverImpl(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean autodetectEncoding = false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private HashMap<String, Set<String>> featuresMap;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FTPClient() {
/*  645 */     initDefaults();
/*  646 */     this.dataTimeoutMillis = -1;
/*  647 */     this.remoteVerificationEnabled = true;
/*  648 */     this.parserFactory = (FTPFileEntryParserFactory)new DefaultFTPFileEntryParserFactory();
/*  649 */     this.configuration = null;
/*  650 */     this.listHiddenFiles = false;
/*  651 */     this.useEPSVwithIPv4 = false;
/*  652 */     this.random = new Random();
/*  653 */     this.passiveLocalHost = null;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void _connectAction_() throws IOException {
/*  658 */     _connectAction_((Reader)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void _connectAction_(Reader paramReader) throws IOException {
/*  668 */     super._connectAction_(paramReader);
/*  669 */     initDefaults();
/*      */ 
/*      */     
/*  672 */     if (this.autodetectEncoding) {
/*  673 */       ArrayList<String> arrayList = new ArrayList<>(this._replyLines);
/*  674 */       int i = this._replyCode;
/*  675 */       if (hasFeature("UTF8") || hasFeature("UTF-8")) {
/*      */         
/*  677 */         setControlEncoding("UTF-8");
/*  678 */         this._controlInput_ = (BufferedReader)new CRLFLineReader(new InputStreamReader(this._input_, getControlEncoding()));
/*  679 */         this._controlOutput_ = new BufferedWriter(new OutputStreamWriter(this._output_, getControlEncoding()));
/*      */       } 
/*      */       
/*  682 */       this._replyLines.clear();
/*  683 */       this._replyLines.addAll(arrayList);
/*  684 */       this._replyCode = i;
/*  685 */       this._newReplyString = true;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Socket _openDataConnection_(FTPCmd paramFTPCmd, String paramString) throws IOException {
/*  711 */     return _openDataConnection_(paramFTPCmd.getCommand(), paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   protected Socket _openDataConnection_(int paramInt, String paramString) throws IOException {
/*  735 */     return _openDataConnection_(FTPCommand.getCommand(paramInt), paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Socket _openDataConnection_(String paramString1, String paramString2) throws IOException {
/*      */     Socket socket;
/*  760 */     if (this.dataConnectionMode != 0 && this.dataConnectionMode != 2)
/*      */     {
/*  762 */       return null;
/*      */     }
/*      */     
/*  765 */     boolean bool = getRemoteAddress() instanceof java.net.Inet6Address;
/*      */ 
/*      */ 
/*      */     
/*  769 */     if (this.dataConnectionMode == 0) {
/*      */ 
/*      */ 
/*      */       
/*  773 */       try (ServerSocket null = this._serverSocketFactory_.createServerSocket(getActivePort(), 1, getHostAddress()))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  781 */         if (bool) {
/*  782 */           if (!FTPReply.isPositiveCompletion(eprt(getReportHostAddress(), serverSocket.getLocalPort()))) {
/*  783 */             return null;
/*      */           }
/*      */         }
/*  786 */         else if (!FTPReply.isPositiveCompletion(port(getReportHostAddress(), serverSocket.getLocalPort()))) {
/*  787 */           return null;
/*      */         } 
/*      */ 
/*      */         
/*  791 */         if (this.restartOffset > 0L && !restart(this.restartOffset)) {
/*  792 */           return null;
/*      */         }
/*      */         
/*  795 */         if (!FTPReply.isPositivePreliminary(sendCommand(paramString1, paramString2))) {
/*  796 */           return null;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  803 */         if (this.dataTimeoutMillis >= 0) {
/*  804 */           serverSocket.setSoTimeout(this.dataTimeoutMillis);
/*      */         }
/*  806 */         socket = serverSocket.accept();
/*      */ 
/*      */         
/*  809 */         if (this.dataTimeoutMillis >= 0) {
/*  810 */           socket.setSoTimeout(this.dataTimeoutMillis);
/*      */         }
/*  812 */         if (this.receiveDataSocketBufferSize > 0) {
/*  813 */           socket.setReceiveBufferSize(this.receiveDataSocketBufferSize);
/*      */         }
/*  815 */         if (this.sendDataSocketBufferSize > 0) {
/*  816 */           socket.setSendBufferSize(this.sendDataSocketBufferSize);
/*      */ 
/*      */         
/*      */         }
/*      */ 
/*      */       
/*      */       }
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */       
/*  830 */       boolean bool1 = (isUseEPSVwithIPv4() || bool) ? true : false;
/*  831 */       if (bool1 && epsv() == 229) {
/*      */         
/*  833 */         _parseExtendedPassiveModeReply(this._replyLines.get(0));
/*      */       }
/*      */       else {
/*      */         
/*  837 */         if (bool) {
/*  838 */           return null;
/*      */         }
/*      */         
/*  841 */         if (pasv() != 227) {
/*  842 */           return null;
/*      */         }
/*  844 */         _parsePassiveModeReply(this._replyLines.get(0));
/*      */       } 
/*      */       
/*  847 */       socket = this._socketFactory_.createSocket();
/*  848 */       if (this.receiveDataSocketBufferSize > 0) {
/*  849 */         socket.setReceiveBufferSize(this.receiveDataSocketBufferSize);
/*      */       }
/*  851 */       if (this.sendDataSocketBufferSize > 0) {
/*  852 */         socket.setSendBufferSize(this.sendDataSocketBufferSize);
/*      */       }
/*  854 */       if (this.passiveLocalHost != null) {
/*  855 */         socket.bind(new InetSocketAddress(this.passiveLocalHost, 0));
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  862 */       if (this.dataTimeoutMillis >= 0) {
/*  863 */         socket.setSoTimeout(this.dataTimeoutMillis);
/*      */       }
/*      */       
/*  866 */       socket.connect(new InetSocketAddress(this.passiveHost, this.passivePort), this.connectTimeout);
/*  867 */       if (this.restartOffset > 0L && !restart(this.restartOffset)) {
/*      */         
/*  869 */         socket.close();
/*  870 */         return null;
/*      */       } 
/*      */       
/*  873 */       if (!FTPReply.isPositivePreliminary(sendCommand(paramString1, paramString2))) {
/*      */         
/*  875 */         socket.close();
/*  876 */         return null;
/*      */       } 
/*      */     } 
/*      */     
/*  880 */     if (this.remoteVerificationEnabled && !verifyRemote(socket)) {
/*      */ 
/*      */       
/*  883 */       InetAddress inetAddress = socket.getInetAddress();
/*      */       
/*  885 */       socket.close();
/*      */       
/*  887 */       throw new IOException("Host attempting data connection " + inetAddress
/*  888 */           .getHostAddress() + " is not same as server " + 
/*  889 */           getRemoteAddress().getHostAddress());
/*      */     } 
/*      */     
/*  892 */     return socket;
/*      */   }
/*      */   protected void _parseExtendedPassiveModeReply(String paramString) throws MalformedServerReplyException {
/*      */     int i;
/*  896 */     paramString = paramString.substring(paramString.indexOf('(') + 1, paramString.indexOf(')')).trim();
/*      */     
/*  898 */     char c1 = paramString.charAt(0);
/*  899 */     char c2 = paramString.charAt(1);
/*  900 */     char c3 = paramString.charAt(2);
/*  901 */     char c4 = paramString.charAt(paramString.length() - 1);
/*      */     
/*  903 */     if (c1 != c2 || c2 != c3 || c3 != c4) {
/*  904 */       throw new MalformedServerReplyException("Could not parse extended passive host information.\nServer Reply: " + paramString);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/*  910 */       i = Integer.parseInt(paramString.substring(3, paramString.length() - 1));
/*  911 */     } catch (NumberFormatException numberFormatException) {
/*  912 */       throw new MalformedServerReplyException("Could not parse extended passive host information.\nServer Reply: " + paramString);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  917 */     this.passiveHost = getRemoteAddress().getHostAddress();
/*  918 */     this.passivePort = i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void _parsePassiveModeReply(String paramString) throws MalformedServerReplyException {
/*  927 */     Matcher matcher = PARMS_PAT.matcher(paramString);
/*  928 */     if (!matcher.find()) {
/*  929 */       throw new MalformedServerReplyException("Could not parse passive host information.\nServer Reply: " + paramString);
/*      */     }
/*      */ 
/*      */     
/*  933 */     this
/*  934 */       .passiveHost = "0,0,0,0".equals(matcher.group(1)) ? this._socket_.getInetAddress().getHostAddress() : matcher.group(1).replace(',', '.');
/*      */     
/*      */     try {
/*  937 */       int i = Integer.parseInt(matcher.group(2));
/*  938 */       int j = Integer.parseInt(matcher.group(3));
/*  939 */       this.passivePort = i << 8 | j;
/*  940 */     } catch (NumberFormatException numberFormatException) {
/*  941 */       throw new MalformedServerReplyException("Could not parse passive port information.\nServer Reply: " + paramString);
/*      */     } 
/*      */ 
/*      */     
/*  945 */     if (this.passiveNatWorkaroundStrategy != null) {
/*      */       try {
/*  947 */         String str = this.passiveNatWorkaroundStrategy.resolve(this.passiveHost);
/*  948 */         if (!this.passiveHost.equals(str)) {
/*  949 */           fireReplyReceived(0, "[Replacing PASV mode reply address " + this.passiveHost + " with " + str + "]\n");
/*      */           
/*  951 */           this.passiveHost = str;
/*      */         } 
/*  953 */       } catch (UnknownHostException unknownHostException) {
/*  954 */         throw new MalformedServerReplyException("Could not parse passive host information.\nServer Reply: " + paramString);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean _retrieveFile(String paramString1, String paramString2, OutputStream paramOutputStream) throws IOException {
/*  971 */     Socket socket = _openDataConnection_(paramString1, paramString2);
/*      */     
/*  973 */     if (socket == null) {
/*  974 */       return false;
/*      */     }
/*      */     
/*  977 */     FromNetASCIIInputStream fromNetASCIIInputStream = null;
/*  978 */     CSL cSL = null; try {
/*      */       InputStream inputStream;
/*      */       try {
/*  981 */         if (this.fileType == 0) {
/*  982 */           fromNetASCIIInputStream = new FromNetASCIIInputStream(getBufferedInputStream(socket.getInputStream()));
/*      */         } else {
/*  984 */           inputStream = getBufferedInputStream(socket.getInputStream());
/*      */         } 
/*      */         
/*  987 */         if (this.controlKeepAliveTimeoutMillis > 0L) {
/*  988 */           cSL = new CSL(this, this.controlKeepAliveTimeoutMillis, this.controlKeepAliveReplyTimeoutMillis);
/*      */         }
/*      */ 
/*      */         
/*  992 */         Util.copyStream(inputStream, paramOutputStream, getBufferSize(), -1L, mergeListeners(cSL), false);
/*      */       } finally {
/*      */         
/*  995 */         Util.closeQuietly(inputStream);
/*      */       } 
/*      */       
/*  998 */       return completePendingCommand();
/*      */     } finally {
/* 1000 */       Util.closeQuietly(socket);
/* 1001 */       if (cSL != null) {
/* 1002 */         this.cslDebug = cSL.cleanUp();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected InputStream _retrieveFileStream(String paramString1, String paramString2) throws IOException {
/*      */     InputStream inputStream;
/* 1018 */     Socket socket = _openDataConnection_(paramString1, paramString2);
/*      */     
/* 1020 */     if (socket == null) {
/* 1021 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 1025 */     if (this.fileType == 0) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1033 */       FromNetASCIIInputStream fromNetASCIIInputStream = new FromNetASCIIInputStream(getBufferedInputStream(socket.getInputStream()));
/*      */     } else {
/* 1035 */       inputStream = socket.getInputStream();
/*      */     } 
/* 1037 */     return (InputStream)new SocketInputStream(socket, inputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean _storeFile(String paramString1, String paramString2, InputStream paramInputStream) throws IOException {
/*      */     OutputStream outputStream;
/* 1053 */     Socket socket = _openDataConnection_(paramString1, paramString2);
/*      */     
/* 1055 */     if (socket == null) {
/* 1056 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1061 */     if (this.fileType == 0) {
/* 1062 */       ToNetASCIIOutputStream toNetASCIIOutputStream = new ToNetASCIIOutputStream(getBufferedOutputStream(socket.getOutputStream()));
/*      */     } else {
/* 1064 */       outputStream = getBufferedOutputStream(socket.getOutputStream());
/*      */     } 
/*      */     
/* 1067 */     CSL cSL = null;
/* 1068 */     if (this.controlKeepAliveTimeoutMillis > 0L) {
/* 1069 */       cSL = new CSL(this, this.controlKeepAliveTimeoutMillis, this.controlKeepAliveReplyTimeoutMillis);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/* 1075 */       Util.copyStream(paramInputStream, outputStream, getBufferSize(), -1L, 
/* 1076 */           mergeListeners(cSL), false);
/*      */       
/* 1078 */       outputStream.close();
/* 1079 */       socket.close();
/*      */ 
/*      */       
/* 1082 */       return completePendingCommand();
/*      */     }
/* 1084 */     catch (IOException iOException) {
/*      */       
/* 1086 */       Util.closeQuietly(outputStream);
/* 1087 */       Util.closeQuietly(socket);
/* 1088 */       throw iOException;
/*      */     } finally {
/* 1090 */       if (cSL != null) {
/* 1091 */         this.cslDebug = cSL.cleanUp();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected OutputStream _storeFileStream(String paramString1, String paramString2) throws IOException {
/*      */     OutputStream outputStream;
/* 1106 */     Socket socket = _openDataConnection_(paramString1, paramString2);
/*      */     
/* 1108 */     if (socket == null) {
/* 1109 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 1113 */     if (this.fileType == 0) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1121 */       ToNetASCIIOutputStream toNetASCIIOutputStream = new ToNetASCIIOutputStream(getBufferedOutputStream(socket.getOutputStream()));
/*      */     } else {
/* 1123 */       outputStream = socket.getOutputStream();
/*      */     } 
/* 1125 */     return (OutputStream)new SocketOutputStream(socket, outputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean abort() throws IOException {
/* 1142 */     return FTPReply.isPositiveCompletion(abor());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean allocate(int paramInt) throws IOException {
/* 1160 */     return FTPReply.isPositiveCompletion(allo(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean allocate(int paramInt1, int paramInt2) throws IOException {
/* 1179 */     return FTPReply.isPositiveCompletion(allo(paramInt1, paramInt2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean allocate(long paramLong) throws IOException {
/* 1197 */     return FTPReply.isPositiveCompletion(allo(paramLong));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean allocate(long paramLong, int paramInt) throws IOException {
/* 1216 */     return FTPReply.isPositiveCompletion(allo(paramLong, paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean appendFile(String paramString, InputStream paramInputStream) throws IOException {
/* 1247 */     return storeFile(FTPCmd.APPE, paramString, paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public OutputStream appendFileStream(String paramString) throws IOException {
/* 1280 */     return storeFileStream(FTPCmd.APPE, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean changeToParentDirectory() throws IOException {
/* 1298 */     return FTPReply.isPositiveCompletion(cdup());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean changeWorkingDirectory(String paramString) throws IOException {
/* 1317 */     return FTPReply.isPositiveCompletion(cwd(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean completePendingCommand() throws IOException {
/* 1366 */     return FTPReply.isPositiveCompletion(getReply());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void configure(FTPClientConfig paramFTPClientConfig) {
/* 1379 */     this.configuration = paramFTPClientConfig;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void createParser(String paramString) throws IOException {
/* 1387 */     if (this.entryParser == null || (paramString != null && !this.entryParserKey.equals(paramString))) {
/* 1388 */       if (null != paramString) {
/*      */ 
/*      */         
/* 1391 */         this
/* 1392 */           .entryParser = this.parserFactory.createFileEntryParser(paramString);
/* 1393 */         this.entryParserKey = paramString;
/*      */ 
/*      */ 
/*      */       
/*      */       }
/* 1398 */       else if (null != this.configuration && this.configuration.getServerSystemKey().length() > 0) {
/* 1399 */         this
/* 1400 */           .entryParser = this.parserFactory.createFileEntryParser(this.configuration);
/* 1401 */         this.entryParserKey = this.configuration.getServerSystemKey();
/*      */       
/*      */       }
/*      */       else {
/*      */ 
/*      */         
/* 1407 */         String str = System.getProperty("org.apache.commons.net.ftp.systemType");
/* 1408 */         if (str == null) {
/* 1409 */           str = getSystemType();
/* 1410 */           Properties properties = getOverrideProperties();
/* 1411 */           if (properties != null) {
/* 1412 */             String str1 = properties.getProperty(str);
/* 1413 */             if (str1 != null) {
/* 1414 */               str = str1;
/*      */             }
/*      */           } 
/*      */         } 
/* 1418 */         if (null != this.configuration) {
/* 1419 */           this.entryParser = this.parserFactory.createFileEntryParser(new FTPClientConfig(str, this.configuration));
/*      */         } else {
/* 1421 */           this.entryParser = this.parserFactory.createFileEntryParser(str);
/*      */         } 
/* 1423 */         this.entryParserKey = str;
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean deleteFile(String paramString) throws IOException {
/* 1444 */     return FTPReply.isPositiveCompletion(dele(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void disconnect() throws IOException {
/* 1456 */     super.disconnect();
/* 1457 */     initDefaults();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean doCommand(String paramString1, String paramString2) throws IOException {
/* 1478 */     return FTPReply.isPositiveCompletion(sendCommand(paramString1, paramString2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] doCommandAsStrings(String paramString1, String paramString2) throws IOException {
/* 1499 */     boolean bool = FTPReply.isPositiveCompletion(sendCommand(paramString1, paramString2));
/* 1500 */     if (bool) {
/* 1501 */       return getReplyStrings();
/*      */     }
/* 1503 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void enterLocalActiveMode() {
/* 1517 */     this.dataConnectionMode = 0;
/* 1518 */     this.passiveHost = null;
/* 1519 */     this.passivePort = -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void enterLocalPassiveMode() {
/* 1539 */     this.dataConnectionMode = 2;
/*      */ 
/*      */     
/* 1542 */     this.passiveHost = null;
/* 1543 */     this.passivePort = -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean enterRemoteActiveMode(InetAddress paramInetAddress, int paramInt) throws IOException {
/* 1573 */     if (FTPReply.isPositiveCompletion(port(paramInetAddress, paramInt))) {
/*      */       
/* 1575 */       this.dataConnectionMode = 1;
/* 1576 */       this.passiveHost = null;
/* 1577 */       this.passivePort = -1;
/* 1578 */       return true;
/*      */     } 
/* 1580 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean enterRemotePassiveMode() throws IOException {
/* 1607 */     if (pasv() != 227) {
/* 1608 */       return false;
/*      */     }
/*      */     
/* 1611 */     this.dataConnectionMode = 3;
/* 1612 */     _parsePassiveModeReply(this._replyLines.get(0));
/*      */     
/* 1614 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean features() throws IOException {
/* 1635 */     return FTPReply.isPositiveCompletion(feat());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String featureValue(String paramString) throws IOException {
/* 1651 */     String[] arrayOfString = featureValues(paramString);
/* 1652 */     if (arrayOfString != null) {
/* 1653 */       return arrayOfString[0];
/*      */     }
/* 1655 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] featureValues(String paramString) throws IOException {
/* 1670 */     if (!initFeatureMap()) {
/* 1671 */       return null;
/*      */     }
/* 1673 */     Set set = this.featuresMap.get(paramString.toUpperCase(Locale.ENGLISH));
/* 1674 */     if (set != null) {
/* 1675 */       return (String[])set.toArray((Object[])NetConstants.EMPTY_STRING_ARRAY);
/*      */     }
/* 1677 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int getActivePort() {
/* 1687 */     if (this.activeMinPort > 0 && this.activeMaxPort >= this.activeMinPort) {
/*      */       
/* 1689 */       if (this.activeMaxPort == this.activeMinPort) {
/* 1690 */         return this.activeMaxPort;
/*      */       }
/*      */       
/* 1693 */       return this.random.nextInt(this.activeMaxPort - this.activeMinPort + 1) + this.activeMinPort;
/*      */     } 
/*      */     
/* 1696 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getAutodetectUTF8() {
/* 1705 */     return this.autodetectEncoding;
/*      */   }
/*      */   
/*      */   private InputStream getBufferedInputStream(InputStream paramInputStream) {
/* 1709 */     if (this.bufferSize > 0) {
/* 1710 */       return new BufferedInputStream(paramInputStream, this.bufferSize);
/*      */     }
/* 1712 */     return new BufferedInputStream(paramInputStream);
/*      */   }
/*      */   
/*      */   private OutputStream getBufferedOutputStream(OutputStream paramOutputStream) {
/* 1716 */     if (this.bufferSize > 0) {
/* 1717 */       return new BufferedOutputStream(paramOutputStream, this.bufferSize);
/*      */     }
/* 1719 */     return new BufferedOutputStream(paramOutputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getBufferSize() {
/* 1727 */     return this.bufferSize;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getControlKeepAliveReplyTimeout() {
/* 1736 */     return this.controlKeepAliveReplyTimeoutMillis;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getControlKeepAliveTimeout() {
/* 1749 */     return this.controlKeepAliveTimeoutMillis / 1000L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CopyStreamListener getCopyStreamListener() {
/* 1759 */     return this.copyStreamListener;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public int[] getCslDebug() {
/* 1779 */     return this.cslDebug;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDataConnectionMode() {
/* 1791 */     return this.dataConnectionMode;
/*      */   }
/*      */ 
/*      */   
/*      */   FTPFileEntryParser getEntryParser() {
/* 1796 */     return this.entryParser;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private InetAddress getHostAddress() {
/* 1807 */     if (this.activeExternalHost != null)
/*      */     {
/* 1809 */       return this.activeExternalHost;
/*      */     }
/*      */     
/* 1812 */     return getLocalAddress();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getListArguments(String paramString) {
/* 1821 */     if (getListHiddenFiles()) {
/*      */       
/* 1823 */       if (paramString != null) {
/*      */         
/* 1825 */         StringBuilder stringBuilder = new StringBuilder(paramString.length() + 3);
/* 1826 */         stringBuilder.append("-a ");
/* 1827 */         stringBuilder.append(paramString);
/* 1828 */         return stringBuilder.toString();
/*      */       } 
/* 1830 */       return "-a";
/*      */     } 
/*      */     
/* 1833 */     return paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getListHiddenFiles() {
/* 1842 */     return this.listHiddenFiles;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getModificationTime(String paramString) throws IOException {
/* 1857 */     if (FTPReply.isPositiveCompletion(mdtm(paramString)))
/*      */     {
/* 1859 */       return getReplyString(0).substring(4);
/*      */     }
/* 1861 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPassiveHost() {
/* 1878 */     return this.passiveHost;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public InetAddress getPassiveLocalIPAddress() {
/* 1889 */     return this.passiveLocalHost;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getPassivePort() {
/* 1906 */     return this.passivePort;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getReceiveDataSocketBufferSize() {
/* 1915 */     return this.receiveDataSocketBufferSize;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private InetAddress getReportHostAddress() {
/* 1927 */     if (this.reportActiveExternalHost != null) {
/* 1928 */       return this.reportActiveExternalHost;
/*      */     }
/* 1930 */     return getHostAddress();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getRestartOffset() {
/* 1941 */     return this.restartOffset;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSendDataSocketBufferSize() {
/* 1950 */     return this.sendDataSocketBufferSize;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSize(String paramString) throws IOException {
/* 1971 */     if (FTPReply.isPositiveCompletion(size(paramString))) {
/* 1972 */       return getReplyString(0).substring(4);
/*      */     }
/* 1974 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStatus() throws IOException {
/* 1991 */     if (FTPReply.isPositiveCompletion(stat())) {
/* 1992 */       return getReplyString();
/*      */     }
/* 1994 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getStatus(String paramString) throws IOException {
/* 2013 */     if (FTPReply.isPositiveCompletion(stat(paramString))) {
/* 2014 */       return getReplyString();
/*      */     }
/* 2016 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public String getSystemName() throws IOException {
/* 2027 */     if (this.systemName == null && FTPReply.isPositiveCompletion(syst())) {
/* 2028 */       this.systemName = ((String)this._replyLines.get(this._replyLines.size() - 1)).substring(4);
/*      */     }
/* 2030 */     return this.systemName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSystemType() throws IOException {
/* 2060 */     if (this.systemName == null) {
/* 2061 */       if (FTPReply.isPositiveCompletion(syst())) {
/*      */         
/* 2063 */         this.systemName = ((String)this._replyLines.get(this._replyLines.size() - 1)).substring(4);
/*      */       } else {
/*      */         
/* 2066 */         String str = System.getProperty("org.apache.commons.net.ftp.systemType.default");
/* 2067 */         if (str != null) {
/* 2068 */           this.systemName = str;
/*      */         } else {
/* 2070 */           throw new IOException("Unable to determine system type - response: " + getReplyString());
/*      */         } 
/*      */       } 
/*      */     }
/* 2074 */     return this.systemName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasFeature(FTPCmd paramFTPCmd) throws IOException {
/* 2090 */     return hasFeature(paramFTPCmd.name());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasFeature(String paramString) throws IOException {
/* 2106 */     if (!initFeatureMap()) {
/* 2107 */       return false;
/*      */     }
/* 2109 */     return this.featuresMap.containsKey(paramString.toUpperCase(Locale.ENGLISH));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasFeature(String paramString1, String paramString2) throws IOException {
/* 2128 */     if (!initFeatureMap()) {
/* 2129 */       return false;
/*      */     }
/* 2131 */     Set set = this.featuresMap.get(paramString1.toUpperCase(Locale.ENGLISH));
/* 2132 */     if (set != null) {
/* 2133 */       return set.contains(paramString2);
/*      */     }
/* 2135 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void initDefaults() {
/* 2140 */     this.dataConnectionMode = 0;
/* 2141 */     this.passiveHost = null;
/* 2142 */     this.passivePort = -1;
/* 2143 */     this.activeExternalHost = null;
/* 2144 */     this.reportActiveExternalHost = null;
/* 2145 */     this.activeMinPort = 0;
/* 2146 */     this.activeMaxPort = 0;
/* 2147 */     this.fileType = 0;
/* 2148 */     this.fileStructure = 7;
/* 2149 */     this.fileFormat = 4;
/* 2150 */     this.fileTransferMode = 10;
/* 2151 */     this.restartOffset = 0L;
/* 2152 */     this.systemName = null;
/* 2153 */     this.entryParser = null;
/* 2154 */     this.entryParserKey = "";
/* 2155 */     this.featuresMap = null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean initFeatureMap() throws IOException {
/* 2162 */     if (this.featuresMap == null) {
/*      */       
/* 2164 */       int i = feat();
/* 2165 */       if (i == 530) {
/* 2166 */         return false;
/*      */       }
/* 2168 */       boolean bool = FTPReply.isPositiveCompletion(i);
/*      */       
/* 2170 */       this.featuresMap = new HashMap<>();
/* 2171 */       if (!bool) {
/* 2172 */         return false;
/*      */       }
/* 2174 */       for (String str : this._replyLines) {
/* 2175 */         if (str.startsWith(" ")) {
/*      */           
/* 2177 */           String str2 = "";
/* 2178 */           int j = str.indexOf(' ', 1);
/* 2179 */           if (j > 0) {
/* 2180 */             str1 = str.substring(1, j);
/* 2181 */             str2 = str.substring(j + 1);
/*      */           } else {
/* 2183 */             str1 = str.substring(1);
/*      */           } 
/* 2185 */           String str1 = str1.toUpperCase(Locale.ENGLISH);
/* 2186 */           Set<String> set = this.featuresMap.get(str1);
/* 2187 */           if (set == null) {
/* 2188 */             set = new HashSet();
/* 2189 */             this.featuresMap.put(str1, set);
/*      */           } 
/* 2191 */           set.add(str2);
/*      */         } 
/*      */       } 
/*      */     } 
/* 2195 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FTPListParseEngine initiateListParsing() throws IOException {
/* 2234 */     return initiateListParsing((String)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private FTPListParseEngine initiateListParsing(FTPFileEntryParser paramFTPFileEntryParser, String paramString) throws IOException {
/* 2255 */     Socket socket = _openDataConnection_(FTPCmd.LIST, getListArguments(paramString));
/*      */     
/* 2257 */     FTPListParseEngine fTPListParseEngine = new FTPListParseEngine(paramFTPFileEntryParser, this.configuration);
/* 2258 */     if (socket == null)
/*      */     {
/* 2260 */       return fTPListParseEngine;
/*      */     }
/*      */     
/*      */     try {
/* 2264 */       fTPListParseEngine.readServerList(socket.getInputStream(), getControlEncoding());
/*      */     } finally {
/*      */       
/* 2267 */       Util.closeQuietly(socket);
/*      */     } 
/*      */     
/* 2270 */     completePendingCommand();
/* 2271 */     return fTPListParseEngine;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FTPListParseEngine initiateListParsing(String paramString) throws IOException {
/* 2327 */     return initiateListParsing((String)null, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FTPListParseEngine initiateListParsing(String paramString1, String paramString2) throws IOException {
/* 2389 */     createParser(paramString1);
/* 2390 */     return initiateListParsing(this.entryParser, paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FTPListParseEngine initiateMListParsing() throws IOException {
/* 2401 */     return initiateMListParsing((String)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FTPListParseEngine initiateMListParsing(String paramString) throws IOException {
/* 2413 */     Socket socket = _openDataConnection_(FTPCmd.MLSD, paramString);
/* 2414 */     FTPListParseEngine fTPListParseEngine = new FTPListParseEngine((FTPFileEntryParser)MLSxEntryParser.getInstance(), this.configuration);
/* 2415 */     if (socket == null)
/*      */     {
/* 2417 */       return fTPListParseEngine;
/*      */     }
/*      */     
/*      */     try {
/* 2421 */       fTPListParseEngine.readServerList(socket.getInputStream(), getControlEncoding());
/*      */     } finally {
/*      */       
/* 2424 */       Util.closeQuietly(socket);
/* 2425 */       completePendingCommand();
/*      */     } 
/* 2427 */     return fTPListParseEngine;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isRemoteVerificationEnabled() {
/* 2439 */     return this.remoteVerificationEnabled;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isUseEPSVwithIPv4() {
/* 2449 */     return this.useEPSVwithIPv4;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FTPFile[] listDirectories() throws IOException {
/* 2496 */     return listDirectories((String)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FTPFile[] listDirectories(String paramString) throws IOException {
/* 2544 */     return listFiles(paramString, FTPFileFilters.DIRECTORIES);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FTPFile[] listFiles() throws IOException {
/* 2595 */     return listFiles((String)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FTPFile[] listFiles(String paramString) throws IOException {
/* 2651 */     return initiateListParsing((String)null, paramString).getFiles();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FTPFile[] listFiles(String paramString, FTPFileFilter paramFTPFileFilter) throws IOException {
/* 2664 */     return initiateListParsing((String)null, paramString).getFiles(paramFTPFileFilter);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String listHelp() throws IOException {
/* 2682 */     return FTPReply.isPositiveCompletion(help()) ? getReplyString() : null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String listHelp(String paramString) throws IOException {
/* 2700 */     return FTPReply.isPositiveCompletion(help(paramString)) ? getReplyString() : null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] listNames() throws IOException {
/* 2726 */     return listNames((String)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String[] listNames(String paramString) throws IOException {
/* 2760 */     ArrayList<String> arrayList = new ArrayList();
/* 2761 */     try (Socket null = _openDataConnection_(FTPCmd.NLST, getListArguments(paramString))) {
/*      */       
/* 2763 */       if (socket == null) {
/* 2764 */         return null;
/*      */       }
/*      */       
/* 2767 */       try (BufferedReader null = new BufferedReader(new InputStreamReader(socket
/* 2768 */               .getInputStream(), getControlEncoding()))) {
/*      */         String str;
/*      */         
/* 2771 */         while ((str = bufferedReader.readLine()) != null) {
/* 2772 */           arrayList.add(str);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 2777 */     if (completePendingCommand()) {
/* 2778 */       return arrayList.<String>toArray(NetConstants.EMPTY_STRING_ARRAY);
/*      */     }
/*      */     
/* 2781 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean login(String paramString1, String paramString2) throws IOException {
/* 2801 */     user(paramString1);
/*      */     
/* 2803 */     if (FTPReply.isPositiveCompletion(this._replyCode)) {
/* 2804 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 2809 */     if (!FTPReply.isPositiveIntermediate(this._replyCode)) {
/* 2810 */       return false;
/*      */     }
/*      */     
/* 2813 */     return FTPReply.isPositiveCompletion(pass(paramString2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean login(String paramString1, String paramString2, String paramString3) throws IOException {
/* 2836 */     user(paramString1);
/*      */     
/* 2838 */     if (FTPReply.isPositiveCompletion(this._replyCode)) {
/* 2839 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 2844 */     if (!FTPReply.isPositiveIntermediate(this._replyCode)) {
/* 2845 */       return false;
/*      */     }
/*      */     
/* 2848 */     pass(paramString2);
/*      */     
/* 2850 */     if (FTPReply.isPositiveCompletion(this._replyCode)) {
/* 2851 */       return true;
/*      */     }
/*      */     
/* 2854 */     if (!FTPReply.isPositiveIntermediate(this._replyCode)) {
/* 2855 */       return false;
/*      */     }
/*      */     
/* 2858 */     return FTPReply.isPositiveCompletion(acct(paramString3));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean logout() throws IOException {
/* 2875 */     return FTPReply.isPositiveCompletion(quit());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean makeDirectory(String paramString) throws IOException {
/* 2895 */     return FTPReply.isPositiveCompletion(mkd(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Calendar mdtmCalendar(String paramString) throws IOException {
/* 2911 */     String str = getModificationTime(paramString);
/* 2912 */     if (str != null) {
/* 2913 */       return MLSxEntryParser.parseGMTdateTime(str);
/*      */     }
/* 2915 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FTPFile mdtmFile(String paramString) throws IOException {
/* 2931 */     String str = getModificationTime(paramString);
/* 2932 */     if (str != null) {
/* 2933 */       FTPFile fTPFile = new FTPFile();
/* 2934 */       fTPFile.setName(paramString);
/* 2935 */       fTPFile.setRawListing(str);
/* 2936 */       fTPFile.setTimestamp(MLSxEntryParser.parseGMTdateTime(str));
/* 2937 */       return fTPFile;
/*      */     } 
/* 2939 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private CopyStreamListener mergeListeners(CopyStreamListener paramCopyStreamListener) {
/* 2950 */     if (paramCopyStreamListener == null) {
/* 2951 */       return this.copyStreamListener;
/*      */     }
/* 2953 */     if (this.copyStreamListener == null) {
/* 2954 */       return paramCopyStreamListener;
/*      */     }
/*      */     
/* 2957 */     CopyStreamAdapter copyStreamAdapter = new CopyStreamAdapter();
/* 2958 */     copyStreamAdapter.addCopyStreamListener(paramCopyStreamListener);
/* 2959 */     copyStreamAdapter.addCopyStreamListener(this.copyStreamListener);
/* 2960 */     return (CopyStreamListener)copyStreamAdapter;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FTPFile[] mlistDir() throws IOException {
/* 2972 */     return mlistDir((String)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FTPFile[] mlistDir(String paramString) throws IOException {
/* 2984 */     return initiateMListParsing(paramString).getFiles();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FTPFile[] mlistDir(String paramString, FTPFileFilter paramFTPFileFilter) throws IOException {
/* 2997 */     return initiateMListParsing(paramString).getFiles(paramFTPFileFilter);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FTPFile mlistFile(String paramString) throws IOException {
/* 3010 */     boolean bool = FTPReply.isPositiveCompletion(sendCommand(FTPCmd.MLST, paramString));
/* 3011 */     if (bool) {
/* 3012 */       String str1 = getReplyString(1);
/*      */       
/* 3014 */       if (str1.charAt(0) != ' ') str1 = " " + str1;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3019 */       if (str1.length() < 3) {
/* 3020 */         throw new MalformedServerReplyException("Invalid server reply (MLST): '" + str1 + "'");
/*      */       }
/*      */       
/* 3023 */       String str2 = str1.replaceAll("^\\s+", "");
/* 3024 */       return MLSxEntryParser.parseEntry(str2);
/*      */     } 
/* 3026 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String printWorkingDirectory() throws IOException {
/* 3044 */     if (pwd() != 257) {
/* 3045 */       return null;
/*      */     }
/*      */     
/* 3048 */     return parsePathname(this._replyLines.get(this._replyLines.size() - 1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean reinitialize() throws IOException {
/* 3067 */     rein();
/*      */     
/* 3069 */     if (FTPReply.isPositiveCompletion(this._replyCode) || (
/* 3070 */       FTPReply.isPositivePreliminary(this._replyCode) && 
/* 3071 */       FTPReply.isPositiveCompletion(getReply()))) {
/*      */ 
/*      */       
/* 3074 */       initDefaults();
/*      */       
/* 3076 */       return true;
/*      */     } 
/*      */     
/* 3079 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean remoteAppend(String paramString) throws IOException {
/* 3103 */     if (this.dataConnectionMode == 1 || this.dataConnectionMode == 3)
/*      */     {
/* 3105 */       return FTPReply.isPositivePreliminary(appe(paramString));
/*      */     }
/* 3107 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean remoteRetrieve(String paramString) throws IOException {
/* 3127 */     if (this.dataConnectionMode == 1 || this.dataConnectionMode == 3)
/*      */     {
/* 3129 */       return FTPReply.isPositivePreliminary(retr(paramString));
/*      */     }
/* 3131 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean remoteStore(String paramString) throws IOException {
/* 3153 */     if (this.dataConnectionMode == 1 || this.dataConnectionMode == 3)
/*      */     {
/* 3155 */       return FTPReply.isPositivePreliminary(stor(paramString));
/*      */     }
/* 3157 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean remoteStoreUnique() throws IOException {
/* 3180 */     if (this.dataConnectionMode == 1 || this.dataConnectionMode == 3)
/*      */     {
/* 3182 */       return FTPReply.isPositivePreliminary(stou());
/*      */     }
/* 3184 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean remoteStoreUnique(String paramString) throws IOException {
/* 3207 */     if (this.dataConnectionMode == 1 || this.dataConnectionMode == 3)
/*      */     {
/* 3209 */       return FTPReply.isPositivePreliminary(stou(paramString));
/*      */     }
/* 3211 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean removeDirectory(String paramString) throws IOException {
/* 3229 */     return FTPReply.isPositiveCompletion(rmd(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean rename(String paramString1, String paramString2) throws IOException {
/* 3248 */     if (!FTPReply.isPositiveIntermediate(rnfr(paramString1))) {
/* 3249 */       return false;
/*      */     }
/*      */     
/* 3252 */     return FTPReply.isPositiveCompletion(rnto(paramString2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean restart(long paramLong) throws IOException {
/* 3276 */     this.restartOffset = 0L;
/* 3277 */     return FTPReply.isPositiveIntermediate(rest(Long.toString(paramLong)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean retrieveFile(String paramString, OutputStream paramOutputStream) throws IOException {
/* 3308 */     return _retrieveFile(FTPCmd.RETR.getCommand(), paramString, paramOutputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public InputStream retrieveFileStream(String paramString) throws IOException {
/* 3342 */     return _retrieveFileStream(FTPCmd.RETR.getCommand(), paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean sendNoOp() throws IOException {
/* 3361 */     return FTPReply.isPositiveCompletion(noop());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean sendSiteCommand(String paramString) throws IOException {
/* 3378 */     return FTPReply.isPositiveCompletion(site(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActiveExternalIPAddress(String paramString) throws UnknownHostException {
/* 3391 */     this.activeExternalHost = InetAddress.getByName(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActivePortRange(int paramInt1, int paramInt2) {
/* 3403 */     this.activeMinPort = paramInt1;
/* 3404 */     this.activeMaxPort = paramInt2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAutodetectUTF8(boolean paramBoolean) {
/* 3416 */     this.autodetectEncoding = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBufferSize(int paramInt) {
/* 3425 */     this.bufferSize = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setControlKeepAliveReplyTimeout(int paramInt) {
/* 3436 */     this.controlKeepAliveReplyTimeoutMillis = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setControlKeepAliveTimeout(long paramLong) {
/* 3450 */     this.controlKeepAliveTimeoutMillis = paramLong * 1000L;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCopyStreamListener(CopyStreamListener paramCopyStreamListener) {
/* 3461 */     this.copyStreamListener = paramCopyStreamListener;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDataTimeout(int paramInt) {
/* 3476 */     this.dataTimeoutMillis = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFileStructure(int paramInt) throws IOException {
/* 3497 */     if (FTPReply.isPositiveCompletion(stru(paramInt))) {
/*      */       
/* 3499 */       this.fileStructure = paramInt;
/* 3500 */       return true;
/*      */     } 
/* 3502 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFileTransferMode(int paramInt) throws IOException {
/* 3523 */     if (FTPReply.isPositiveCompletion(mode(paramInt))) {
/*      */       
/* 3525 */       this.fileTransferMode = paramInt;
/* 3526 */       return true;
/*      */     } 
/* 3528 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFileType(int paramInt) throws IOException {
/* 3559 */     if (FTPReply.isPositiveCompletion(type(paramInt))) {
/*      */       
/* 3561 */       this.fileType = paramInt;
/* 3562 */       this.fileFormat = 4;
/* 3563 */       return true;
/*      */     } 
/* 3565 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setFileType(int paramInt1, int paramInt2) throws IOException {
/* 3607 */     if (FTPReply.isPositiveCompletion(type(paramInt1, paramInt2))) {
/*      */       
/* 3609 */       this.fileType = paramInt1;
/* 3610 */       this.fileFormat = paramInt2;
/* 3611 */       return true;
/*      */     } 
/* 3613 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setListHiddenFiles(boolean paramBoolean) {
/* 3626 */     this.listHiddenFiles = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setModificationTime(String paramString1, String paramString2) throws IOException {
/* 3647 */     return FTPReply.isPositiveCompletion(mfmt(paramString1, paramString2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setParserFactory(FTPFileEntryParserFactory paramFTPFileEntryParserFactory) {
/* 3660 */     this.parserFactory = paramFTPFileEntryParserFactory;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPassiveLocalIPAddress(InetAddress paramInetAddress) {
/* 3671 */     this.passiveLocalHost = paramInetAddress;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPassiveLocalIPAddress(String paramString) throws UnknownHostException {
/* 3683 */     this.passiveLocalHost = InetAddress.getByName(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void setPassiveNatWorkaround(boolean paramBoolean) {
/* 3701 */     if (paramBoolean) {
/* 3702 */       this.passiveNatWorkaroundStrategy = new NatServerResolverImpl(this);
/*      */     } else {
/* 3704 */       this.passiveNatWorkaroundStrategy = null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPassiveNatWorkaroundStrategy(HostnameResolver paramHostnameResolver) {
/* 3719 */     this.passiveNatWorkaroundStrategy = paramHostnameResolver;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setReceieveDataSocketBufferSize(int paramInt) {
/* 3730 */     this.receiveDataSocketBufferSize = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRemoteVerificationEnabled(boolean paramBoolean) {
/* 3744 */     this.remoteVerificationEnabled = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setReportActiveExternalIPAddress(String paramString) throws UnknownHostException {
/* 3758 */     this.reportActiveExternalHost = InetAddress.getByName(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRestartOffset(long paramLong) {
/* 3779 */     if (paramLong >= 0L) {
/* 3780 */       this.restartOffset = paramLong;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSendDataSocketBufferSize(int paramInt) {
/* 3792 */     this.sendDataSocketBufferSize = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUseEPSVwithIPv4(boolean paramBoolean) {
/* 3810 */     this.useEPSVwithIPv4 = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean storeFile(FTPCmd paramFTPCmd, String paramString, InputStream paramInputStream) throws IOException {
/* 3816 */     return _storeFile(paramFTPCmd.getCommand(), paramString, paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean storeFile(String paramString, InputStream paramInputStream) throws IOException {
/* 3846 */     return storeFile(FTPCmd.STOR, paramString, paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private OutputStream storeFileStream(FTPCmd paramFTPCmd, String paramString) throws IOException {
/* 3852 */     return _storeFileStream(paramFTPCmd.getCommand(), paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public OutputStream storeFileStream(String paramString) throws IOException {
/* 3885 */     return storeFileStream(FTPCmd.STOR, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean storeUniqueFile(InputStream paramInputStream) throws IOException {
/* 3914 */     return storeFile(FTPCmd.STOU, (String)null, paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean storeUniqueFile(String paramString, InputStream paramInputStream) throws IOException {
/* 3946 */     return storeFile(FTPCmd.STOU, paramString, paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public OutputStream storeUniqueFileStream() throws IOException {
/* 3979 */     return storeFileStream(FTPCmd.STOU, (String)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public OutputStream storeUniqueFileStream(String paramString) throws IOException {
/* 4014 */     return storeFileStream(FTPCmd.STOU, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean structureMount(String paramString) throws IOException {
/* 4032 */     return FTPReply.isPositiveCompletion(smnt(paramString));
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\FTPClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */