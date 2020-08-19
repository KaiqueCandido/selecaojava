print('Start #################################################################');

db = db.getSiblingDB('selecaojava');
db.createUser(
  {
    user: 'root',
    pwd: 'root',
    roles: [{ role: 'readWrite', db: 'selecaojava' }],
  },
);
db.createCollection('pessoa');

print('END #################################################################');