개인키생성

```
openssl genrsa -aes256 -out privatekey.pem 2048
```

CSR 파일 생성

```
openssl req -new -key privatekey.pem -out netty.csr
```

전자서명으로 인증서 만들기

```
openssl x509 -in netty.csr -out netty.csr -req -signkey privatekey.pem -days 356
```

