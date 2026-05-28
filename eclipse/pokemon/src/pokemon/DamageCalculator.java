package pokemon;

public class DamageCalculator {
	public int execute(Pokemon attacker, Pokemon defender, Move move) {
		double levelFactor = (attacker.getLevel() * 2 / 5.0) + 2;
		double baseDamage = 2 + (levelFactor * move.getPower() * attacker.getAttack() / defender.getDefense()) / 50;
		double modifier = getModifier(attacker, defender, move);
		return (int) (baseDamage * modifier);
	}

	private double getModifier(Pokemon attacker, Pokemon defender, Move move) {
		double modifier = 1.0;
		TypeCompatibility typeCom = new TypeCompatibility();
		typeCom.setTypeChart();
		if(move.getType().getType().equals(attacker.getType1().getType()) || move.getType().getType().equals(attacker.getType2().getType())) {
			modifier = 1.5;
		}
		return modifier * typeCom.getTypeChart().get(move.getType().getType()).get(defender.getType1().getType()) * typeCom.getTypeChart().get(move.getType().getType()).get(defender.getType2().getType());
	}
}
