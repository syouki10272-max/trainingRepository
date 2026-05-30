package pokemon;

public class pokemonTest {
	public static void main(String[] args) {
		Pokemon attacker = new Pokemon();
		Pokemon defender = new Pokemon();
		Type water = new Type("みず");
		Type ground = new Type("じめん");
		Type ghost = new Type("ゴースト");
		Type type = new Type("null");
		attacker.setAttack(164);
		attacker.setType1(water);
		attacker.setType2(ghost);
		attacker.setLevel(50);
		attacker.setName("アタッカー");
		attacker.setAttacking(true);
		attacker.setCaracteristic(new Caracteristics("てきおうりょく", 4.0/3.0, true));
		defender.setName("ディフェンダー");
		defender.setDefense(167);
		defender.setLevel(50);
		defender.setType1(ground);
		defender.setType2(type);
		defender.setAttacking(false);
		defender.setCaracteristic(new Caracteristics("防御", 1.0, false));
		Move move = new Move("ウェーブタックル",120,water);
		TypeCompatibility typeCom = new TypeCompatibility();
		typeCom.setTypeChart();
		DamageCalculator dmgCalc = new DamageCalculator();
		int dmg = dmgCalc.execute(attacker, defender, move);
		System.out.println(attacker.getName() + "の、" + move.getName() + "！");
		for(int i = 85; i <= 100; i++) {
			System.out.println("乱数" + i + "%: " + (int)(dmg * i / 100.0));
		}
	}
}
