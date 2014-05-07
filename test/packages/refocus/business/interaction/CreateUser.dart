library interaction.CreateUser;

import 'package:refocus/business.dart';

class CreateUser {
  String username;
  String password;

  CreateUser(this.username, this.password);

  void execute() {
    User user = new User(this.username, this.password);
  }
}
