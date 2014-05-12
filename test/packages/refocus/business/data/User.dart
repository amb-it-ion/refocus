library domain.data.User;

import 'package:refocus/business/context/Owner.dart';
import 'package:refocus/business/context/Named.dart';

class User extends Object with Owner, Named {
  String username;
  String password;
  List test;


  User(this.username, this.password );
}
