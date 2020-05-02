# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# This file is the source Rails uses to define your schema when running `rails
# db:schema:load`. When creating a new database, `rails db:schema:load` tends to
# be faster and is potentially less error prone than running all of your
# migrations from scratch. Old migrations may fail to apply correctly if those
# migrations use external dependencies or application code.
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 2020_04_30_143548) do

  # These are extensions that must be enabled in order to support this database
  enable_extension "plpgsql"

  create_table "companionships", force: :cascade do |t|
    t.bigint "green_id", null: false
    t.string "companion_type"
    t.bigint "companion_id", null: false
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
    t.index ["companion_id"], name: "index_companionships_on_companion_id"
    t.index ["green_id"], name: "index_companionships_on_green_id"
  end

  create_table "greens", force: :cascade do |t|
    t.string "name"
    t.text "description"
    t.int4range "sow_period"
    t.int4range "grow_period"
    t.int4range "harvest_period"
    t.datetime "created_at", precision: 6, null: false
    t.datetime "updated_at", precision: 6, null: false
    t.index ["name"], name: "index_greens_on_name", unique: true
  end

  add_foreign_key "companionships", "greens"
  add_foreign_key "companionships", "greens", column: "companion_id"
end
