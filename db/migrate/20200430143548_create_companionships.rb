class CreateCompanionships < ActiveRecord::Migration[6.0]
  def change
    create_table :companionships do |t|
      t.references :green, null: false, foreign_key: {to_table: :greens}
      t.string :companion_type
      t.references :companion, null: false, foreign_key: {to_table: :greens}

      t.timestamps
    end
  end
end
