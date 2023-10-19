package kadai;

public class Lux extends Champion {
	public void attack(Monster[] m) {
		super.attack(m);
		int selected = Main.scanner.nextInt() - 1;
		if (selected < m.length && m[selected].hp > 0) {
			System.out.println(this.name + "のターン!!");
			System.out.println("「え〜い⭐️」");
			super.time();
			int dmg = this.ad - m[selected].ar;
			if(dmg <= 0) {
				dmg =0;
			}
			System.out.println(m[selected].name + "に" + dmg + "のダメージ!!");
			m[selected].takeDamage(dmg);
			super.time();
		} else {
			System.out.println("狙いが定まらない！");
			this.attack(m);
		}
	}

	public void skillR(Monster[] m) {
		System.out.println(this.name + "のターン!!");
		super.time();
		System.out.println(this.name + "のビームが炸裂!!");
		super.time();
		System.out.println("「DEMAAACIAAA!!!」");
		super.time();
		for (Monster monster : m) {
			if(monster.hp >=0) {
			int dmg = this.ap * 2;
			System.out.println(monster.name + "に" + dmg + "のダメージ!!");
			monster.takeDamage(dmg);
			}
			super.time();
		}
	}

	public void comando(Champion[] c,Monster[] m,ConsumptionItem i) {
		System.out.println("行うコマンドを数字で選択してください。");
		System.out.println("1:攻撃 2:逃げる 3:体力確認 4:ULT 5:アイテム");
		int selected = Main.scanner.nextInt();
		switch (selected) {
		case 1:
			this.attack(m);
			break;
		case 2:
			this.run();
			break;
		case 3:
			this.check(c,m);
			this.comando(c,m,i);
			break;
		case 4:
			this.skillR(m);
			break;
		case 5:
			this.useItem(c,m,i);
			break;
		default:
			System.out.println("そんなコマンドはない！！");
		}
	}

	public Lux() {
		this.name = "ラックス";
		this.hp = 560;
		this.maxHp = 560;
		this.ad = 54;
		this.ap = 100;
		this.ar = 10;
		this.pick = false;
		this.haveItem = false;
	}
}