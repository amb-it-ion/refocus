library interaction.CreateItem;

import 'package:refocus/business.dart';

class CreateItem {
  String name;
  Owner owner;

  CreateItem(this.name, this.owner);

  void execute() {
    Item item = new Item(this.name, this.owner);
  }
}
