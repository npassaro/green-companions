class CreateGreens < ActiveRecord::Migration[6.0]
  def change
    create_table :greens do |t|
      t.string :name
      t.text :description
      t.int4range :sow_period
      t.int4range :grow_period
      t.int4range :harvest_period

      t.timestamps
    end
  end
end
