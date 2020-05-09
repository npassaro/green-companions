class CreateGreens < ActiveRecord::Migration[6.0]
  def change
    create_table :greens do |t|
      t.string :name
      t.text :description
      t.integer :sow_period, array: true, default: []
      t.integer :grow_period, array: true, default: []
      t.integer :harvest_period, array: true, default: []

      t.timestamps
    end
  end
end
