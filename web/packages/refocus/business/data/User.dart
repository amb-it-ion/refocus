library domain.data.User;

import 'package:refocus/business/context/Owner.dart';

class User extends Object with Owner {
  String username;
  String password;
  List test;

  User(this.username, this.password);
}
