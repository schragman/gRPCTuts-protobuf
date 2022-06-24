package net.schrage.protobuf;

import net.schrage.models.Credentials;
import net.schrage.models.EmailCredentials;
import net.schrage.models.PhoneOTP;

public class OneOfDemo {

  public static void main(String[] args) {

    EmailCredentials emailCredentials = EmailCredentials.newBuilder()
        .setEmail("schragman@gmail.com")
        .setPassword("123")
        .build();

    PhoneOTP phoneOTP = PhoneOTP.newBuilder()
        .setNumber(123456)
        .setCode(456)
        .build();

    Credentials credentials = Credentials.newBuilder()
        .setEmailMode(emailCredentials)
        .setPhoneMode(phoneOTP)
        .build();

    login(credentials);

  }


  private static void login(Credentials credentials) {

    switch (credentials.getModeCase()) {
      case EMAILMODE:
        System.out.println(credentials.getEmailMode());
        break;
      case PHONEMODE:
        System.out.println(credentials.getPhoneMode());
        break;
    }

  }

}
