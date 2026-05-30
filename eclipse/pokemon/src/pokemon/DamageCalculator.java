package pokemon;

public class DamageCalculator {
	public int execute(Pokemon attacker, Pokemon defender, Move move) {
		double levelFactor = (attacker.getLevel() * 2 / 5.0) + 2;
		int baseDamage = (int) ( 2 + (levelFactor * move.getPower() * attacker.getAttack() / defender.getDefense()) / 50);	
		double modifier = getModifier(attacker, defender, move);
		return (int) (baseDamage * modifier);
	}

	private double getModifier(Pokemon attacker, Pokemon defender, Move move) {
		double modifier = 1.0;

		if(move.getType().getType().equals(attacker.getType1().getType()) || move.getType().getType().equals(attacker.getType2().getType())) {
			modifier *= 1.5;
		}
		double effect = 1.0;
		if(attacker.isAttacking() == attacker.getCaracteristic().isAttacking()) {
			effect *= attacker.getCaracteristic().getEffect();
		}
		if(defender.isAttacking() == defender.getCaracteristic().isAttacking()) {
			effect *= defender.getCaracteristic().getEffect();
		}
		System.out.println(effect);

		TypeCompatibility typeCom = new TypeCompatibility();
		typeCom.setTypeChart();

		return modifier * effect * typeCom.getTypeChart().get(move.getType().getType()).get(defender.getType1().getType()) * typeCom.getTypeChart().get(move.getType().getType()).get(defender.getType2().getType());
	}
}
