class AddIndexToGreens < ActiveRecord::Migration[6.0]
  def change
    add_index :greens, :name, :unique => true
  end
end
