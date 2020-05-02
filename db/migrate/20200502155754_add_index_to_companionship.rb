class AddIndexToCompanionship < ActiveRecord::Migration[6.0]
  def change
    add_index :companionships, [:green_id, :companion_id, :companion_type ], unique: true
  end
end
