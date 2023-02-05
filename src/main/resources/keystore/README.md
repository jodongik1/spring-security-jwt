# HTTPS 인증서 
```
# 1) keystore 생성
keytool -genkey -alias [키저장소별칭] -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore [키저장할파일이름]

예) 
keytool -genkey -alias api-server -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore api-server.pkcs12

# 2) keystore 생성 확인
keytool -list -v -keystore [keystore 파일이름]

예)
keytool -list -v -keystore api-server.pkcs12

# 3) keystore에서 인증서 export
keytool -export -alias [keystore 별칭] -keystore [keystore 파일이름] -rfc -file [인증서파일이름]

예)
keytool -export -alias api-server -keystore api-server.pkcs12 -rfc -file api-server.cer

# 4) 인증서 확인
type api-server.cer

# 5) trust store 생성
keytool -import -alias [trust store 별칭] -file [인증서파일이름] -keystore [trust store 파일이름]

#sample
keytool -import -alias api-server -file api-server.cer -keystore api-server-trust.pkcs12

server.port=8443
server.ssl.key-store=api-server.pkcs12
server.ssl.key-store-password=123456
server.ssl.key-alias=api-server
server.ssl.trust-store=api-server-trust.pkcs12
server.ssl.trust-store-password=123456
```

# JOSE 인증서  
```
// RSA Keypair 생성
$ openssl genrsa -out sander_keypair.pem 2048
$ openssl genrsa -out receive_keypair.pem 2048

// To extract the public part, use the rsa context:
$ openssl rsa -in sander_keypair.pem -pubout -out sander_publickey.crt
$ openssl rsa -in receive_keypair.pem -pubout -out receive_publickey.crt

// convert the original keypair to PKCS#8 format with the pkcs8 context:
$ openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in sander_keypair.pem -out sander_privatekey_pkcs8.key
$ openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in receive_keypair.pem -out receive_privatekey_pkcs8.key
```
		